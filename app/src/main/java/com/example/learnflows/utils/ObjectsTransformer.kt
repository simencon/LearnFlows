package com.example.learnflows.utils

import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

private const val TAG = "ObjectsTransformer"

open class ObjectTransformer<in T : Any, out R : Any>
constructor(inClass: KClass<T>, outClass: KClass<R>) {
    private val outConstructor = outClass.primaryConstructor!!
    private val inPropertiesByName by lazy {
        inClass.memberProperties.associateBy { it.name }
    }

    fun transform(data: T): R = with(outConstructor) {
        callBy(parameters.associate { parameter ->
            parameter to argFor(parameter, data)
        })
    }

    open fun argFor(parameter: KParameter, data: T): Any? {
        return when (parameter.name) {
//            Fields added only in domain model
            "channelsVisibility" -> {
                false
            }
            "linesVisibility" -> {
                false
            }
            "operationVisibility" -> {
                false
            }
            "detailsVisibility" -> {
                false
            }
            "subOrdersVisibility" -> {
                false
            }
            "tasksVisibility" -> {
                false
            }
            "measurementsVisibility" -> {
                false
            }
            "isExpanded" -> {
                false
            }
            "isSelected" -> {
                false
            }
            "isNewRecord" -> {
                false
            }
            "toBeDeleted" -> {
                false
            }
            else -> return inPropertiesByName[parameter.name]?.get(data)
        }
    }
}

class ListTransformer<in T : Any, out R : Any> constructor(
    inClass: KClass<T>, outClass: KClass<R>
) {
    private var inputList: List<T> = listOf()

    constructor(inList: List<T>, inClass: KClass<T>, outClass: KClass<R>) : this(
        inClass,
        outClass
    ) {
        inputList = inList
    }

    private val outConstructor = outClass.primaryConstructor!!
    private val inPropertiesByName by lazy {
        inClass.memberProperties.associateBy { it.name }
    }

    fun transform(data: T): R = with(outConstructor) {
        callBy(parameters.associate { parameter ->
            parameter to argFor(parameter, data)
        })
    }

    fun argFor(parameter: KParameter, data: T): Any? {
        return when (parameter.name) {
//            Fields added only in domain model
            "channelsVisibility" -> {
                false
            }
            "linesVisibility" -> {
                false
            }
            "operationVisibility" -> {
                false
            }
            "detailsVisibility" -> {
                false
            }
            "subOrdersVisibility" -> {
                false
            }
            "tasksVisibility" -> {
                false
            }
            "measurementsVisibility" -> {
                false
            }
            "isExpanded" -> {
                false
            }
            "isSelected" -> {
                false
            }
            "isNewRecord" -> {
                false
            }
            "toBeDeleted" -> {
                false
            }
            else -> return inPropertiesByName[parameter.name]?.get(data)
        }
    }

    fun generateList(): List<R> {
        return inputList.map() {
            transform(it)
        }
    }
}