package com.example.concesionariobbdd;

/**
 * Esta es la clase Concesionario, que representa los coches disponibles en un concesionario.
 * Tiene atributos como el código, la marca, el modelo, el año de fabricación, el número de bastidor,
 * el precio, la matrícula y los extras.
 */
public class Concesionario {

    // Atributos de la clase
    String Cod_Coche;          // Código del coche
    String marca;              // Marca del coche
    String modelo;             // Modelo del coche
    String anio_fabricacion;   // Año de fabricación del coche
    String bastidor;           // Número de bastidor del coche
    String precio;             // Precio del coche
    String matricula;          // Matrícula del coche
    String extras;             // Extras del coche

    /**
     * Este método sobrescribe el método toString() para imprimir una cadena con los valores de todos los atributos.
     * @return Cadena de texto que representa el objeto en formato legible para humanos.
     */
    @Override
    public String toString() {
        return "coches{" +
                "cod_coche='" + Cod_Coche + '\'' +
                ", marca='" + marca + '\'' +
                ", anio_fabricacion='" + anio_fabricacion + '\'' +
                ", bastidor='" + bastidor + '\'' +
                ", precio='" + precio + '\'' +
                ", matricula='" + matricula + '\'' +
                ", extras='" + extras + '\'' +
                '}';
    }

    // Métodos "set" para establecer los valores de los atributos

    /**
     * Este método establece el valor del código del coche.
     * @param cod_Coche Código del coche.
     */
    public void setCod_Coche(String cod_Coche) {
        this.Cod_Coche = cod_Coche;
    }

    /**
     * Este método establece el valor de la marca del coche.
     * @param marca Marca del coche.
     */
    public void setmarca(String marca) {
        this.marca = marca;
    }

    /**
     * Este método establece el valor del modelo del coche.
     * @param modelo Modelo del coche.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Este método establece el valor del año de fabricación del coche.
     * @param anio_fabricacion Año de fabricación del coche.
     */
    public void setAnio_fabricacion(String anio_fabricacion) {
        this.anio_fabricacion = anio_fabricacion;
    }

    /**
     * Este método establece el valor del número de bastidor del coche.
     * @param bastidor Número de bastidor del coche.
     */
    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    /**
     * Este método establece el valor del precio del coche.
     * @param precio Precio del coche.
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * Este método establece la matrícula de un coche.
     * @param matricula La matrícula del coche.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**

     Establece los extras del coche
     @param extras los extras del coche
     */
    public void setExtras(String extras) {
        this.extras = extras;
    }
    /**

     Obtiene el código del coche
     @return el código del coche
     */
    public String getCod_Coche() {
        return Cod_Coche;
    }
    /**

     Obtiene el modelo del coche
     @return el modelo del coche
     */
    public String getModelo() {
        return modelo;
    }
    /**

     Obtiene el año de fabricación del coche
     @return el año de fabricación del coche
     */
    public String getAnio_fabricacion() {
        return anio_fabricacion;
    }
    /**

     Obtiene el bastidor del coche
     @return el bastidor del coche
     */
    public String getBastidor() {
        return bastidor;
    }
    /**

     Obtiene el precio del coche
     @return el precio del coche
     */
    public String getPrecio() {
        return precio;
    }
    /**

     Obtiene la marca del coche
     @return la marca del coche
     */
    public String getMarca() {
        return marca;
    }
    /**

     Obtiene la matrícula del coche
     @return la matrícula del coche
     */
    public String getMatricula() {
        return matricula;
    }
    /**

     Obtiene los extras del coche
     @return los extras del coche
     */
    public String getExtras() {
        return extras;
    }
    /**

     Crea un objeto Concesionario
     @param Cod_Coche el código del coche
     @param marca la marca del coche
     @param modelo el modelo del coche
     @param anio_fabricacion el año de fabricación del coche
     @param bastidor el bastidor del coche
     @param precio el precio del coche
     @param matricula la matrícula del coche
     @param extras los extras del coche
     */
    public Concesionario(String Cod_Coche, String marca, String modelo, String anio_fabricacion, String bastidor, String precio, String matricula, String extras) {
        this.Cod_Coche = Cod_Coche;
        this.marca = marca;
        this.modelo = modelo;
        this.anio_fabricacion = anio_fabricacion;
        this.bastidor = bastidor;
        this.precio = precio;
        this.matricula = matricula;
        this.extras = extras;
    }