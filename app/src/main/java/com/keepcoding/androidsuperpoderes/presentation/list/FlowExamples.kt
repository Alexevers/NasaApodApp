package com.keepcoding.androidsuperpoderes.presentation.list

import android.util.Log
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.flow.withIndex

class FlowExamples {

    // Operados funcionales: map, filter
    // Patrón observer
    // Corutinas
    suspend fun createFlowFromList() {
        val list = listOf(
            "1",
            "2",
            "3"
        )
        val flow = list.asFlow()
            .map {
                // No hay opción de devoler más tipos
                "Hello $it"
            }.transform {
                emit(it)
                emit(it)
            }

        flow.collect {
            Log.d("Test", it)
        }
    }

    suspend fun exampleFold() {
        val flow = flow {
            emit(1)
            emit(2)
            emit(3)
            emit(4)
        }

        Log.d("ExampleFlow", "Before")

        val result = flow.fold("Test ") { acc, value ->
            acc + value
        }

        Log.d("ExampleFlow", result.toString())
    }

    suspend fun exercise1() {
        val flow = listOf(
            "Maestro Roshi",
            "Mr. Satán",
            "Krilin",
            "Goku",
            "Vegeta"
        ).asFlow()

        flow.collectIndexed { index, value ->
            Log.d("Test", "Hola, $value, estás en la posición $index")
        }
    }

    suspend fun exercise1Other(
        list: List<String>
    ) {
        val flow = listOf(
            "Maestro Roshi",
            "Mr. Satán",
            "Krilin",
            "Goku",
            "Vegeta"
        ).asFlow().map {
            "Hola, $it, estás en la posición"
        }

        flow.collectIndexed { index, value ->
            Log.d("Test", "$value $index")
        }
    }

    /**
     * Flow que emita sólo el número de letras de un listado de superhéroes que contienen un
     * número de letras impar.
     */
    suspend fun exercise2() {
        val flow = listOf(
            "Maestro Roshi",
            "Mr. Satán",
            "Krilin",
            "Goku",
            "Vegeta"
        ).asFlow()
            .filter {
                it.length % 2 == 1
            }

        flow.collect {
            Log.d("Ejercicio2", "$it | Número letras: ${it.length}")
        }

    }

    suspend fun exercise2Other() {
        val flow = listOf(
            "Maestro Roshi",
            "Mr. Satán",
            "Krilin",
            "Goku",
            "Vegeta"
        ).asFlow().map {
                it.length
            }.filter {
                it % 2 == 1
            }

        flow.collect {
            Log.d("Ejercicio2", "Número letras: $it")
        }
    }

    suspend fun exerciseSum() {
        val list = listOf(
            1,
            5,
            7,
            8
        )

        var result = list
            .asFlow()
            .reduce { acc, b ->
                acc + b
            }

        Log.d("SUM", "Sumatorio: $result")
        // Mostrar un log con el resultado del sumatorio usando flows
    }

    suspend fun exercise3() {
        val heroList = listOf(
            "Maestro Roshi",
            "Mr. Satán",
            "Krilin",
            "Goku",
            "Vegeta",
            "Bulma",
            "Freezer",
            "Beerus",
            "Piccolo",
            "Kaito",
            "Raditz",
            "Célula",
            "Trunks del Futuro",
            "Quake (Daisy Johnson)",
            "starry night",
            "San Goku",
            "Gohan Prime",
            "Broly"
        )
        val result =
            heroList
                .asFlow()
                .filter { it.length % 2 == 1 }
                .take(2)
                .fold("Bienvenido, ") { acc, value ->
                    "$acc $value y"
                }
                /*.withIndex()
                .fold("Bienvenido, ") { acc, value ->
                    if (value.index == 0) {
                        "$acc ${value.value} y"
                    } else {
                        "$acc ${value.value}"
                    }
                }*/
        //Log.d("Exercise3", result)
        Log.d("Exercise3", result.dropLast(2))
    }

    suspend fun exercise3Reduce() {
        val heroList = listOf(
            "Maestro Roshi",
            "Mr. Satán",
            "Krilin",
            "Goku",
            "Vegeta",
            "Bulma",
            "Freezer",
            "Beerus",
            "Piccolo",
            "Kaito",
            "Raditz",
            "Célula",
            "Trunks del Futuro",
            "Quake (Daisy Johnson)",
            "starry night",
            "San Goku",
            "Gohan Prime",
            "Broly"
        )
        val result =
            heroList
                .asFlow()
                .filter { it.length % 2 == 1 }
                .take(2)
                .reduce { acc, value ->
                    "$acc y $value"
                }
        Log.d("Exercise3", "Bienvenido, $result")
    }

}