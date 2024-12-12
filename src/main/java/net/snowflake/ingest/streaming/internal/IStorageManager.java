/*
 * Copyright (c) 2024 Snowflake Computing Inc. All rights reserved.
 */

package net.snowflake.ingest.streaming.internal;

import java.util.Optional;

/**
 * Interface to manage {@link InternalStage} and {@link PresignedUrlExternalVolume} for {@link
 * FlushService}
 */
interface IStorageManager {

  /** Default max upload retries for streaming ingest storage */
  int DEFAULT_MAX_UPLOAD_RETRIES = 5;

  /**
   * Given a fully qualified table name, return the target storage
   *
   * @param fullyQualifiedTableName the target fully qualified table name
   * @return target stage
   */
  // TODO: Use TableRef everywhere instead of constructing strings and passing them around
  // everywhere
  IStorage getStorage(String fullyQualifiedTableName);

  /** Informs the storage manager about a new table that's being ingested into by the client. */
  void registerTable(TableRef tableRef);

  /**
   * Generate a unique blob path and increment the blob sequencer
   *
   * @param fullyQualifiedTableName The table for which the path must be generated
   * @return the blob path
   */
  // TODO: Use TableRef everywhere instead of constructing strings and passing them around
  // everywhere
  BlobPath generateBlobPath(String fullyQualifiedTableName);

  /**
   * Get the unique client prefix generated by the Snowflake server
   *
   * @return the client prefix
   */
  String getClientPrefix();

  /**
   * Get the updated subscoped tokens and location info for this table
   *
   * @param tableRef The table for which to get the location
   * @param fileName Legacy, was used by deprecated GCS codepaths when it didn't support subscoped
   *     tokens. Not in use.
   * @return
   */
  FileLocationInfo getRefreshedLocation(TableRef tableRef, Optional<String> fileName);
}