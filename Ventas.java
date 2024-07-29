public class Ventas{
    private Reservacion reservacion;
    private Localidad localidad;
    private int capacidad;

    public Ventas(){
        this.reservacion = new Reservacion();
        this.localidad = new Localidad();
        this.capacidad = localidad.getCapacidad();
    }

    public void setReservacion(String nombreR, String emailR, int cantR, float presu_maxR, String correlativoo, Localidad localidad){
        if (presu_maxR >= localidad.getPrecio()){
            this.reservacion = new Reservacion(nombreR, emailR, cantR, presu_maxR, correlativoo, localidad);
        }
    }

    public Reservacion getReservacion(){
        return reservacion;
    }

    public void setLocalidad(int capacidad, int posicion){
        this.localidad = new Localidad(capacidad, posicion);
    }

    public Localidad getLocalidad(){
        return localidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}