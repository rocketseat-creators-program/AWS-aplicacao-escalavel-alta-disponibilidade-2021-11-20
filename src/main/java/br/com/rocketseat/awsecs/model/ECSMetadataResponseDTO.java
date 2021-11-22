package br.com.rocketseat.awsecs.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ECSMetadataResponseDTO {
    String Cluster;
    String TaskARN;
    String AvailabilityZone;
    String Family;

    public ECSMetadataResponseDTO() {
    }

    @JsonGetter("Cluster")
    public String getCluster() {
        return Cluster;
    }
    @JsonSetter("Cluster")
    public void setCluster(String cluster) {
        Cluster = cluster;
    }

    @JsonGetter("Family")
    public String getFamily() {
        return Family;
    }
    @JsonSetter("Family")
    public void setFamily(String family) {
        Family = family;
    }

    @JsonGetter("AvailabilityZone")
    public String getAvailabilityZone() {
        return AvailabilityZone;
    }
    @JsonSetter("AvailabilityZone")
    public void setAvailabilityZone(String availabilityZone) {
        AvailabilityZone = availabilityZone;
    }

    @JsonGetter("TaskARN")
    public String getTaskARN() {
        return TaskARN;
    }
    @JsonSetter("TaskARN")
    public void setTaskARN(String taskARN) {
        TaskARN = taskARN;
    }
}
