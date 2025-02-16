/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.flink.shuffle.coordinator.heartbeat;

import com.alibaba.flink.shuffle.common.config.Configuration;
import com.alibaba.flink.shuffle.core.config.HeartbeatOptions;

/** Utils for creating HeartServices. */
public class HeartbeatServicesUtils {

    public static HeartbeatServices createManagerJobHeartbeatServices(Configuration configuration) {
        long heartbeatTimeout =
                configuration.getDuration(HeartbeatOptions.HEARTBEAT_JOB_TIMEOUT).toMillis();

        long heartbeatInterval =
                configuration.getDuration(HeartbeatOptions.HEARTBEAT_JOB_INTERVAL).toMillis();

        return new HeartbeatServices(heartbeatInterval, heartbeatTimeout);
    }

    public static HeartbeatServices createManagerWorkerHeartbeatServices(
            Configuration configuration) {
        long heartbeatInterval =
                configuration.getDuration(HeartbeatOptions.HEARTBEAT_WORKER_INTERVAL).toMillis();

        long heartbeatTimeout =
                configuration.getDuration(HeartbeatOptions.HEARTBEAT_WORKER_TIMEOUT).toMillis();

        return new HeartbeatServices(heartbeatInterval, heartbeatTimeout);
    }
}
