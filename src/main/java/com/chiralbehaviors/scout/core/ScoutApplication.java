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

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.chiralbehaviors.scout.rest.Service;
import com.chiralbehaviors.scout.rest.ServiceResource;

/**
 * @author hparry
 *
 */
public abstract class ScoutApplication extends Application<ScoutConfiguration>{
    
    private List<Service> services;
    

    /* (non-Javadoc)
     * @see io.dropwizard.Application#initialize(io.dropwizard.setup.Bootstrap)
     */
    @Override
    public void initialize(Bootstrap<ScoutConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/ui/", "/ui/"));
    }

    /* (non-Javadoc)
     * @see io.dropwizard.Application#run(io.dropwizard.Configuration, io.dropwizard.setup.Environment)
     */
    @Override
    public final void run(ScoutConfiguration configuration, Environment environment)
                                                                              throws Exception {
        services = getServices();
        if (services == null) {
            services = Collections.emptyList();
        }
        
        environment.jersey().register(new ServiceResource(services));
        List<ScheduledUpdaterService> emissaries = new ArrayList<>();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(services.size());
        
        for (Service service : services) {
            ScheduledUpdaterService updater = new ScheduledUpdaterService(service);
            scheduler.scheduleAtFixedRate(updater, 0, 10, TimeUnit.SECONDS);
            emissaries.add(updater);
        }
        
    }

    /**
     * @return a list of Services to be monitored
     */
    public abstract List<Service> getServices();

}
