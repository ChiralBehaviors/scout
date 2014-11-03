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
package com.chiralbehaviors.scout.server;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.chiralbehaviors.scout.core.Scout;
import com.chiralbehaviors.scout.rest.ServiceResource;

/**
 * @author hparry
 *
 */
public class ScoutApplication extends Application<ScoutConfiguration> {


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
    public final void run(ScoutConfiguration configuration,
                          Environment environment) throws Exception {
        Scout scout = new Scout();

        environment.jersey().register(new ServiceResource(scout.getServices()));
        
        scout.startServices();
    }

}
