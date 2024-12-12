/*
 * Copyright (c) 2024 Snowflake Computing Inc. All rights reserved.
 */

package net.snowflake.ingest.streaming.internal;

/**
 * Interface that represents a storage location to which we should upload data files. It is the
 * account's internal stage for snowflake tables, and the table's external volume for iceberg
 * tables.
 */
interface IStorage {
  /**
   * Writes out the byte[] to the path passed in.
   *
   * @param blobPath
   * @param blob
   */
  void put(BlobPath blobPath, byte[] blob);
}