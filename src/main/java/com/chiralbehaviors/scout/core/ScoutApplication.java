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
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.List;

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
        
    }

    /* (non-Javadoc)
     * @see io.dropwizard.Application#run(io.dropwizard.Configuration, io.dropwizard.setup.Environment)
     */
    @Override
    public final void run(ScoutConfiguration configuration, Environment environment)
                                                                              throws Exception {
        services = getServices();
        environment.jersey().register(new ServiceResource(services));
        while (true) {
            for (Service service : services) {
                service.updateStatus();
            }
            Thread.sleep(10000);
        }
        
    }

    /**
     * @return a list of Services to be monitored
     */
    public abstract List<Service> getServices();

}
