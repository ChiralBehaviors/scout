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

import com.chiralbehaviors.scout.rest.Service;

/**
 * @author hparry
 *
 */
public class SampleScoutApplication extends ScoutApplication {

    public static void main(String[] argv) throws Exception {
        new SampleScoutApplication().run(argv);
    }

    /* (non-Javadoc)
     * @see com.chiralbehaviors.scout.core.ScoutApplication#getServices()
     */
    @Override
    public List<Service> getServices() {
        List<Service> services = new ArrayList<>();
        services.add(new TestService());
        return services;
    }
}
