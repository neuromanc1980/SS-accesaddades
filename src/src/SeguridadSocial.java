package src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeguridadSocial {

    private List<Persona> personasList;



    public SeguridadSocial() {

        personasList = new ArrayList<>();

    }

// Debes comprobar que no se introduzcan dos personas con el mismo DNI/Número Seguridad Social

    public void altaPersona(Persona persona) {

        //if (!personasList.contains(persona)){
        boolean repetida = false;

        for (Persona personaActual : personasList){
            if (personaActual.getDNI().equals(persona.getDNI()) ||
                    personaActual.getNumSeguridadSocial().equals(persona.getNumSeguridadSocial())){
                    repetida = true;
                break;
            }
        }

        if (!repetida){
            personasList.add(persona);
        }

        //java8
        if( personasList.stream().noneMatch(personaActual -> personaActual.getDNI().equals(persona.getDNI()) ||
                personaActual.getNumSeguridadSocial().equals(persona.getNumSeguridadSocial()))){
            personasList.add(persona);
        }
    }

    public void bajaPersona(String dni) {

        //j8
        personasList.removeIf(persona -> persona.getDNI().equals(dni));

        Persona aux = null;
        for (Persona persona: personasList){
            if (persona.getDNI().equals(dni)){
                aux = persona;
                break;
            }
        }

        if (aux != null) {
            personasList.remove(aux);
        }

    }

    public Persona obtenerPersonaPorDNI(String dni) {

        //j8
        return personasList.
                parallelStream().
                filter(persona -> persona.getDNI().equals(dni)).
                findFirst().get();


        /*Persona aux = null;
        for (Persona persona: personasList){
            if (persona.getDNI().equals(dni)){
                aux = persona;
                break;
            }
        }
        return aux;*/
    }

    public Persona obtenerPersonaPorNumSS(String numSS) {

        //j8
        return personasList.parallelStream().
                filter(persona -> persona.getNumSeguridadSocial().equals(numSS)).
                findFirst().get();



    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){

        List<Persona> aux = new ArrayList<>();

        for (Persona persona: personasList){
            if (persona.getSalario() >= min && persona.getSalario() <= max){
                aux.add(persona);
            }
        }
        return aux;

        //j8
       /*return personasList.parallelStream().
                filter(persona -> persona.getSalario() >= min && persona.getSalario() <= max).
                collect(Collectors.toList());*/
    }

    public List<Persona> obtenerPersonasMayoresQue(int edad){

    }

    public List<Persona> obtenerTodas(){

    }

    @Override

    public String toString() {

        return "SeguridadSocial{" +

                "personasList=" + personasList +

                '}';

    }

}

