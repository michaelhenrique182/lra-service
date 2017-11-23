package org.learn.lra.coreapi

data class ProductInfo(val productId: String = "", val comment: String = "", val price: Int = 0)

data class ShipmentInfo(val shipmentId: String = "", val shippingPrice: Int = 0)
