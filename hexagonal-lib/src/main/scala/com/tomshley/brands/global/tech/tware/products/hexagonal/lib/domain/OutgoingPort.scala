package com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain

trait OutgoingPort[T1 <: Model, T2 <: OutgoingModel] extends Port[T1, T2] with PortExecution[T1, T2]
