package com.example.fipe_catalog_kotlin.data

import com.example.fipe_catalog_kotlin.model.Carro
import com.example.fipe_catalog_kotlin.R

object DadosCatalogo {

    fun getLista(categoria: String): List<Carro> {

        return when (categoria) {

            "suv" -> listOf(

                Carro(
                    "Jeep Compass",
                    "SUV moderno com design sofisticado, conforto interno e ótimo desempenho urbano.",
                    R.drawable.jeep,
                    185000.0,
                    2023
                ),

                Carro(
                    "Toyota SW4",
                    "SUV robusto com espaço interno amplo e excelente desempenho off-road.",
                    R.drawable.toyota,                    368000.0,
                    2024
                ),

                Carro(
                    "Honda HR-V",
                    "SUV compacto econômico, confortável e ideal para uso diário.",
                    R.drawable.honda_jeep,                    162000.0,
                    2023
                )
            )

            "economicos" -> listOf(

                Carro(
                    "Chevrolet Onix",
                    "Hatch econômico com ótimo consumo de combustível e tecnologia moderna.",
                    R.drawable.onix,
                    89000.0,
                    2024
                ),

                Carro(
                    "Hyundai HB20",
                    "Compacto confortável, moderno e ideal para uso urbano.",
                    R.drawable.hb20,
                    95000.0,
                    2023
                ),

                Carro(
                    "Renault Kwid",
                    "Modelo compacto econômico com baixo custo de manutenção.",
                    R.drawable.kwid,
                    72000.0,
                    2024
                )
            )

            "esportivos" -> listOf(

                Carro(
                    "Ford Mustang GT",
                    "Esportivo V8 com desempenho extremo e visual agressivo.",
                    R.drawable.mustang,
                    529000.0,
                    2024
                ),

                Carro(
                    "Chevrolet Camaro",
                    "Muscle car icônico com potência elevada e acabamento esportivo.",
                    R.drawable.camaro,
                    515000.0,
                    2023
                ),

                Carro(
                    "Porsche 911",
                    "Esportivo de luxo com aceleração impressionante e tecnologia premium.",
                    R.drawable.porche,
                    890000.0,
                    2024
                )
            )

            "luxo" -> listOf(

                Carro(
                    "BMW M3",
                    "Sedan esportivo de luxo com alto desempenho e interior refinado.",
                    R.drawable.bmw,
                    650000.0,
                    2024
                ),

                Carro(
                    "Mercedes Classe C",
                    "Modelo sofisticado com conforto premium e tecnologia avançada.",
                    R.drawable.mercedes,
                    420000.0,
                    2023
                ),

                Carro(
                    "Audi A5",
                    "Cupê de luxo com design elegante e performance esportiva.",
                    R.drawable.audi,
                    399000.0,
                    2024
                )
            )

            "eletricos" -> listOf(

                Carro(
                    "Tesla Model S",
                    "Carro elétrico de alta performance com autonomia avançada.",
                    R.drawable.tesla,
                    750000.0,
                    2024
                ),

                Carro(
                    "BYD Dolphin",
                    "Hatch elétrico moderno com excelente custo-benefício.",
                    R.drawable.byd,
                    185000.0,
                    2024
                ),

                Carro(
                    "Volvo EX30",
                    "SUV elétrico compacto com foco em segurança e sustentabilidade.",
                    R.drawable.volvo,
                    290000.0,
                    2024
                )
            )

            "todos" -> listOf(
                *getLista("suv").toTypedArray(),
                *getLista("economicos").toTypedArray(),
                *getLista("esportivos").toTypedArray(),
                *getLista("luxo").toTypedArray(),
                *getLista("eletricos").toTypedArray()
            )

            else -> emptyList()
        }
    }
}