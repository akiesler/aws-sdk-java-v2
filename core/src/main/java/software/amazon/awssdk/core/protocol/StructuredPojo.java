/*
 * Copyright 2010-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.protocol;

import software.amazon.awssdk.annotation.SdkProtectedApi;

/**
 * Interface implemented by model classes so that they may marshaller themselves.
 */
@SdkProtectedApi
public interface StructuredPojo {

    /**
     * Marshalls this structured data using the given {@link ProtocolMarshaller}.
     *
     * @param protocolMarshaller Implementation of {@link ProtocolMarshaller} used to marshall this object's data.
     */
    void marshall(ProtocolMarshaller protocolMarshaller);
}