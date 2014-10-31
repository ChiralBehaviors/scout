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
package com.chiralbehaviors.scout.rest;

import java.util.concurrent.TimeUnit;

/**
 * The interface representing the service or operation to be monitored.
 * @author hparry
 *
 */
public interface Service {

    /**
     * 
     * @return the interval defining the period between status updates. 
     * The unit is determined by the getTimeUnit() return value.
     */
    int getInterval();

    /**
     * 
     * @return the name of the service
     */
    String getName();
    
    TimeUnit getTimeUnit();

    /**
     * 
     * @return the most recent status of the service
     */
    boolean isGreen();

    /**
     * This method is called asynchronously by the dropwizard service to
     * update the status of the monitored service. This method is what updates
     * the isGreen() return value. 
     */
    void updateStatus();

}
