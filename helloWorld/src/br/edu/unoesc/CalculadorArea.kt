package br.edu.unoesc

    fun calcular(superficies: Array<Superficie>):Double {

        var soma:Double = 0.0;

        superficies.forEach { soma += it.getArea() }
        return superficies.map(Superficie::getArea).sum();
}