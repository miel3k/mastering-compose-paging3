package com.miel3k.masteringcomposepaging3.data

/**
 * Created by jmielczarek on 15/10/2022
 */
sealed class RepositoryResult<out R> {
    data class Success<out T>(val data: T) : RepositoryResult<T>()
    data class Error(val exception: Exception) : RepositoryResult<Nothing>()
}