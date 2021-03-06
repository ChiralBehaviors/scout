/**
 * Copyright (c) 2014 Chiral Behaviors, LLC, all rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.chiralbehaviors.scout.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.chiralbehaviors.scout.rest.Service;

/**
 * @author hparry
 *
 */
public class Scout {
    
    private List<Service> services;
    
    public Scout() {
        services = new ArrayList<>();
    }
    
    public List<Service> getServices() {
        return services;
    }
    
    public List<ScheduledUpdaterService> startServices() {
        List<ScheduledUpdaterService> emissaries = new ArrayList<>();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(services.size());

        for (Service service : services) {
            ScheduledUpdaterService updater = new ScheduledUpdaterService(
                                                                          service);
            scheduler.scheduleAtFixedRate(updater, 0, service.getInterval(),
                                          service.getTimeUnit());
            emissaries.add(updater);
        }
        return emissaries;
    }
    
    public void registerService(Service service) {
        services.add(service);
    }

}
