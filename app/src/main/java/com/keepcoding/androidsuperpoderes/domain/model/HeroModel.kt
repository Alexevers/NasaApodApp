package com.keepcoding.androidsuperpoderes.domain.model

data class HeroModel(
    val id: String,
    val date: String,
    val description: String,
    val photo: String
)

// POJO
/*

public class HeroModel {
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