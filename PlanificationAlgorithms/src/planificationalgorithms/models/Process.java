package planificationalgorithms.models;

import java.util.LinkedList;

/**
 *
 * @author Luigi Salcedo
 */
public class Process {
    private String nombre;
    private int tLlegada;
    private int tCpu;
    private int prioridad;
    private LinkedList<Integer> tInicio;
    private LinkedList<Integer> tFinalizacion;
    private Integer tEspera;

    public Process(String nombre, int tLlegada, int tCpu, int prioridad) {
        this.nombre = nombre;
        this.tLlegada = tLlegada;
        this.tCpu = tCpu;
        this.prioridad = prioridad;
        tInicio = new LinkedList<>();
        tFinalizacion = new LinkedList<>();
        tEspera = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int gettLlegada() {
        return tLlegada;
    }

    public void settLlegada(int tLlegada) {
        this.tLlegada = tLlegada;
    }

    public int gettCpu() {
        return tCpu;
    }

    public void settCpu(int tCpu) {
        this.tCpu = tCpu;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public LinkedList<Integer> gettInicio() {
        return tInicio;
    }

    public void settInicio(LinkedList<Integer> tInicio) {
        this.tInicio = tInicio;
    }

    public LinkedList<Integer> gettFinalizacion() {
        return tFinalizacion;
    }

    public void settFinalizacion(LinkedList<Integer> tFinalizacion) {
        this.tFinalizacion = tFinalizacion;
    }

    public Integer gettEspera() {
        return tEspera;
    }

    public void settEspera(Integer tEspera) {
        this.tEspera = tEspera;
    }
    
    @Override
    public String toString() {
        return nombre + " - T. Ini: " + tInicio + " T. Fin: " + tFinalizacion + " T. Esp:" + tEspera;
    }
}
