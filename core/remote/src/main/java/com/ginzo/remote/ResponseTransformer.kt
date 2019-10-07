package com.ginzo.remote

import arrow.core.Either
import io.reactivex.SingleTransformer
import retrofit2.Response
import javax.inject.Inject

class ResponseTransformer @Inject constructor() {
    fun <T, S> responseToEither(map: (T) -> S): SingleTransformer<Response<T>, Either<Throwable, S>> {
        return SingleTransformer { single ->
            single.map { response ->
                Either.cond(
                    response.isSuccessful,
                    { map(response.body()!!) },
                    { Throwable() })
            }
        }
    }
}