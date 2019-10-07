package com.ginzo.feature.productlist.data.repositories

import arrow.core.Either
import com.ginzo.feature.productlist.data.api.ProductListApiRest
import com.ginzo.feature.productlist.data.entities.ItemEntity
import com.ginzo.feature.productlist.data.entities.ProductEntity
import com.ginzo.features.productlist.domain.entities.Product
import com.ginzo.remote.ResponseTransformer
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Single
import org.junit.After
import org.junit.Test
import retrofit2.Response

class ProductListApiRepositoryTest {
	private val apiRest: ProductListApiRest = mock()
	private val responseTransformer: ResponseTransformer = mock()

	private val products = listOf(
		ProductEntity(
			kind = "consumer_goods", item = ItemEntity(
				id = "5a7ab3e09798181675dc1751",
				image = "https://raw.githubusercontent.com/Wallapop/Wallapop-Android-Test-Resources/master/images/image9.jpg",
				price = "447€",
				name = "enim",
				color = "orange",
				category = "children",
				description = "Officia excepteur exercitation laborum cillum occaecat Lorem voluptate ad ullamco adipisicing adipisicing amet non. Dolor exercitation laborum sunt in ex elit officia non labore veniam culpa dolore. Ex ex tempor anim non.",
				distanceInMeters = 414,
				motor = null,
				gearbox = null,
				brand = null,
				km = null,
				closeDay = null,
				minimunAge = null
			)
		)
	)

	private val productListApiRepository = ProductListApiRepository(apiRest, responseTransformer)

	@After
	fun tearDown() {
		verifyNoMoreInteractions(apiRest, responseTransformer)
	}

	@Test
	fun getProducts_OK() {
		whenever(apiRest.getProducts()).doReturn(Single.just(Response.success(products)))

		productListApiRepository.products()
			.test()

		verify(apiRest).getProducts()
	}

}