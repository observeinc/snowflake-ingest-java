/*
 * Copyright (c) 2021 Snowflake Computing Inc. All rights reserved.
 */

package net.snowflake.ingest.streaming.internal;

import java.util.List;
import org.apache.arrow.vector.FieldVector;

/**
 * Contains the data and metadata returned for each channel flush, which will be used to build the
 * blob and register blob request
 */
public class ChannelData {
  private Long rowSequencer;
  private String offsetToken;
  private List<FieldVector> vectors;
  private long rowCount;
  private float bufferSize;
  private SnowflakeStreamingIngestChannelInternal channel;
  private EpInfo epInfo;

  public Long getRowSequencer() {
    return this.rowSequencer;
  }

  public void setRowSequencer(Long rowSequencer) {
    this.rowSequencer = rowSequencer;
  }

  public String getOffsetToken() {
    return this.offsetToken;
  }

  public void setOffsetToken(String offsetToken) {
    this.offsetToken = offsetToken;
  }

  public List<FieldVector> getVectors() {
    return this.vectors;
  }

  public void setVectors(List<FieldVector> vectors) {
    this.vectors = vectors;
  }

  public long getRowCount() {
    return this.rowCount;
  }

  public void setRowCount(long rowCount) {
    this.rowCount = rowCount;
  }

  public float getBufferSize() {
    return this.bufferSize;
  }

  public void setBufferSize(float bufferSize) {
    this.bufferSize = bufferSize;
  }

  public SnowflakeStreamingIngestChannelInternal getChannel() {
    return this.channel;
  }

  public void setChannel(SnowflakeStreamingIngestChannelInternal channel) {
    this.channel = channel;
  }

  public EpInfo getEpInfo() {
    return epInfo;
  }

  public void setEpInfo(EpInfo epInfo) {
    this.epInfo = epInfo;
  }

  @Override
  public String toString() {
    return this.channel.toString();
  }
}
