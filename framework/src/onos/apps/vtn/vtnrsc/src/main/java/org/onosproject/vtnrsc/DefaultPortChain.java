/*
 * Copyright 2015 Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.vtnrsc;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Objects;

import com.google.common.collect.ImmutableList;

/**
 * Implementation of port chain.
 */
public final class DefaultPortChain implements PortChain {

    private final PortChainId portChainId;
    private final TenantId tenantId;
    private final String name;
    private final String description;
    private final List<PortPairGroupId> portPairGroupList;
    private final List<FlowClassifierId> flowClassifierList;

    /**
     * Default constructor to create port chain.
     *
     * @param portChainId port chain id
     * @param tenantId tenant id
     * @param name name of port chain
     * @param description description of port chain
     * @param portPairGroupList port pair group list
     * @param flowClassifierList flow classifier list
     */
    private DefaultPortChain(PortChainId portChainId, TenantId tenantId,
                             String name, String description,
                             List<PortPairGroupId> portPairGroupList,
                             List<FlowClassifierId> flowClassifierList) {

        this.portChainId = portChainId;
        this.tenantId = tenantId;
        this.name = name;
        this.description = description;
        this.portPairGroupList = portPairGroupList;
        this.flowClassifierList = flowClassifierList;
    }

    @Override
    public PortChainId portChainId() {
        return portChainId;
    }

    @Override
    public TenantId tenantId() {
        return tenantId;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public List<PortPairGroupId> portPairGroups() {
        return  ImmutableList.copyOf(portPairGroupList);
    }

    @Override
    public List<FlowClassifierId> flowClassifiers() {
        return ImmutableList.copyOf(flowClassifierList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(portChainId, tenantId, name, description,
                            portPairGroupList, flowClassifierList);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultPortChain) {
            DefaultPortChain that = (DefaultPortChain) obj;
            return Objects.equals(portChainId, that.portChainId) &&
                    Objects.equals(tenantId, that.tenantId) &&
                    Objects.equals(name, that.name) &&
                    Objects.equals(description, that.description) &&
                    Objects.equals(portPairGroupList, that.portPairGroupList) &&
                    Objects.equals(flowClassifierList, that.flowClassifierList);
        }
        return false;
    }

    @Override
    public boolean exactMatch(PortChain portChain) {
        return this.equals(portChain) &&
                Objects.equals(this.portChainId, portChain.portChainId()) &&
                Objects.equals(this.tenantId, portChain.tenantId());
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id", portChainId.toString())
                .add("tenantId", tenantId.toString())
                .add("name", name)
                .add("description", description)
                .add("portPairGroupList", portPairGroupList)
                .add("flowClassifier", flowClassifierList)
                .toString();
    }

    /**
     * To create an instance of the builder.
     *
     * @return instance of builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for Port chain.
     */
    public static final class Builder implements PortChain.Builder {

        private PortChainId portChainId;
        private TenantId tenantId;
        private String name;
        private String description;
        private List<PortPairGroupId> portPairGroupList;
        private List<FlowClassifierId> flowClassifierList;

        @Override
        public Builder setId(PortChainId portChainId) {
            this.portChainId = portChainId;
            return this;
        }

        @Override
        public Builder setTenantId(TenantId tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        @Override
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        @Override
        public Builder setPortPairGroups(List<PortPairGroupId> portPairGroups) {
            this.portPairGroupList = portPairGroups;
            return this;
        }

        @Override
        public Builder setFlowClassifiers(List<FlowClassifierId> flowClassifiers) {
            this.flowClassifierList = flowClassifiers;
            return this;
        }

        @Override
        public PortChain build() {

            checkNotNull(portChainId, "Port chain id cannot be null");
            checkNotNull(tenantId, "Tenant id cannot be null");
            checkNotNull(portPairGroupList, "Port pair groups cannot be null");

            return new DefaultPortChain(portChainId, tenantId, name, description,
                                        portPairGroupList, flowClassifierList);
        }
    }
}
