package com.alejandro.nasaproject.domain.model

data class NasaModel(
    val id: String,
    val date: String,
    val description: String,
    val photo: String
)

// POJO
/*

public class NasaModel {
    private String name;
    private String _name;

    public String getName() {
        return this._name;
    }

    public String setName(String name) {
        this.name = name;
    }
}

*/