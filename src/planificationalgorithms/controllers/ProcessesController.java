package planificationalgorithms.controllers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import org.csalcedo.structures.PriorityLinkedQueue;
import planificationalgorithms.models.Process;

/**
 *
 * @author Luigi Salcedo
 */
public class ProcessesController {
    private PriorityQueue<Process> memory;
    private HashMap<Integer, Process> timeline;
    
    public ProcessesController() {
        
    }
    
    public ProcessesController(HashMap<Integer, Process> timeline) {
        this.timeline = timeline;
    }
    
    public List<Process> FIFOAlgorithm() {
        memory = new PriorityQueue<>(Comparator.comparing(Process::gettLlegada));
        
        List<Process> result = new LinkedList<>();
        
        int totalTime = getTotalTime();
        int minimalTime = getMinimalTime();
        
        Process newProcess;
        Process currentProcess;
        
        for(int i = minimalTime; i < totalTime+minimalTime; i++) {
            newProcess = timeline.get(i);
            if(newProcess != null) {
                memory.offer(newProcess);
            }
            
            if(memory.isEmpty()) {
                continue;
            }
            
            currentProcess =  memory.poll();
            
            // Verifica si es un nuevo proceso en memoria y ponemos su tiempo de inicio
            if(currentProcess.gettInicio().isEmpty()) {
                currentProcess.gettInicio().add(i);
                currentProcess.settEspera(i-currentProcess.gettLlegada());
            }
           
            currentProcess.settCpu(currentProcess.gettCpu()-1);
            
            // Verificar que el proceso haya terminado
            if(currentProcess.gettCpu() == 0) {
                currentProcess.settFinalizacion(new LinkedList<>());
                currentProcess.gettFinalizacion().add(i+1);
                result.add(currentProcess);
                continue;
            }
            
            memory.offer(currentProcess);
        }
        
        return result;
    }
    
    public List<Process> SJFAlgorithm() {
        PriorityLinkedQueue<Process> secondMemory = new PriorityLinkedQueue<>((x, y) -> {
            if(x.gettCpu() == y.gettCpu()) {
                return x.gettLlegada() - y.gettCpu();
            }
            return x.gettCpu() - y.gettCpu();
        });
        
        List<Process> result = new LinkedList<>();
        
        int totalTime = getTotalTime();
        int minimalTime = getMinimalTime();
        
        Process newProcess;
        Process currentProcess = null;

        for(int i = minimalTime; i < totalTime+minimalTime; i++) {
            newProcess = timeline.get(i);
            
            if(newProcess != null) {
                secondMemory.offer(newProcess);
            }
            
            if(secondMemory.isEmpty() && currentProcess == null) {
                continue;
            }
            
            if(currentProcess == null) {
                currentProcess = secondMemory.poll();
            }

            // Verifica si es un nuevo proceso en memoria y ponemos su tiempo de inicio
            if(currentProcess.gettInicio().isEmpty()) {
                currentProcess.gettInicio().add(i);
                currentProcess.settEspera(i-currentProcess.gettLlegada());
            }
           
            currentProcess.settCpu(currentProcess.gettCpu()-1);
            
            // Verificar que el proceso haya terminado
            if(currentProcess.gettCpu() == 0) {
                currentProcess.settFinalizacion(new LinkedList<>());
                currentProcess.gettFinalizacion().add(i+1);
                result.add(currentProcess);
                currentProcess = null;
            }
        }
        
        return result;
    }
    
    public List<Process> SRTFAlgorithm() {
       PriorityLinkedQueue<Process> secondMemory = new PriorityLinkedQueue<>((x, y) -> {
            if(x.gettCpu() == y.gettCpu()) {
                return x.gettLlegada() - y.gettLlegada();
            }
            return x.gettCpu() - y.gettCpu();
        });
        
        List<Process> result = new LinkedList<>();
        
        int totalTime = getTotalTime();
        int minimalTime = getMinimalTime();
        
        Process newProcess;
        Process currentProcess = null;
        Process lastExecuted = null;

        for(int i = minimalTime; i < totalTime+minimalTime; i++) {
            newProcess = timeline.get(i);
            
            if(newProcess != null) {
                secondMemory.offer(newProcess);
            }
            
            if(secondMemory.isEmpty()) {
                continue;
            }
            
            if(currentProcess != null) {
                if(currentProcess != secondMemory.peek() && currentProcess.gettCpu() != 0) {
                    currentProcess.gettFinalizacion().add(i);
                }                
                if(currentProcess != secondMemory.peek() && secondMemory.peek() != null && !secondMemory.peek().gettInicio().isEmpty()) {
                    secondMemory.peek().gettInicio().add(i);
                }
            }
            
            currentProcess = secondMemory.poll();
            
            if(lastExecuted != null && lastExecuted != currentProcess && !currentProcess.gettFinalizacion().isEmpty()) {
                currentProcess.settEspera(currentProcess.gettEspera() + (i - currentProcess.gettFinalizacion().getLast()));
            }
            
            lastExecuted = currentProcess;
            // Verifica si es un nuevo proceso en memoria y ponemos su tiempo de inicio
            if(currentProcess.gettInicio().isEmpty()) {
                currentProcess.gettInicio().add(i);
                currentProcess.settEspera(i-currentProcess.gettLlegada());
            }
           
            currentProcess.settCpu(currentProcess.gettCpu()-1);
            
            // Verificar que el proceso haya terminado
            if(currentProcess.gettCpu() == 0) {
                currentProcess.gettFinalizacion().add(i+1);
                result.add(currentProcess);
                continue;
            }
            
            secondMemory.offer(currentProcess);
        }
        
        return result;        
    }
    
    public List<Process> PriorityAlgorithm() {
       PriorityLinkedQueue<Process> secondMemory = new PriorityLinkedQueue<>((x, y) -> {
            if(x.getPrioridad() == y.getPrioridad()) {
                return x.gettLlegada() - y.gettLlegada();
            }
            return x.getPrioridad() - y.getPrioridad();
        });
        
        List<Process> result = new LinkedList<>();
        
        int totalTime = getTotalTime();
        int minimalTime = getMinimalTime();
        
        Process newProcess;
        Process currentProcess = null;
        Process lastExecuted = null;

        for(int i = minimalTime; i < totalTime+minimalTime; i++) {
            newProcess = timeline.get(i);
            
            if(newProcess != null) {
                secondMemory.offer(newProcess);
            }
            
            if(secondMemory.isEmpty()) {
                continue;
            }
            
            if(currentProcess != null) {
                if(currentProcess != secondMemory.peek() && currentProcess.gettCpu() != 0) {
                    currentProcess.gettFinalizacion().add(i);
                }                
                if(currentProcess != secondMemory.peek() && secondMemory.peek() != null && !secondMemory.peek().gettInicio().isEmpty()) {
                    secondMemory.peek().gettInicio().add(i);
                }
            }
            
            currentProcess = secondMemory.poll();
            
            if(lastExecuted != null && lastExecuted != currentProcess && !currentProcess.gettFinalizacion().isEmpty()) {
                currentProcess.settEspera(currentProcess.gettEspera() + (i - currentProcess.gettFinalizacion().getLast()));
            }
            
            lastExecuted = currentProcess;
            // Verifica si es un nuevo proceso en memoria y ponemos su tiempo de inicio
            if(currentProcess.gettInicio().isEmpty()) {
                currentProcess.gettInicio().add(i);
                currentProcess.settEspera(i-currentProcess.gettLlegada());
            }
           
            currentProcess.settCpu(currentProcess.gettCpu()-1);
            
            // Verificar que el proceso haya terminado
            if(currentProcess.gettCpu() == 0) {
                currentProcess.gettFinalizacion().add(i+1);
                result.add(currentProcess);
                continue;
            }
            
            secondMemory.offer(currentProcess);
        }
        
        return result;        
    }

    private int getTotalTime() {
        return timeline.values().stream().mapToInt(p -> p.gettCpu()).sum();
    }
    
    private int getMinimalTime() {
        return timeline.values().stream().mapToInt(p -> p.gettLlegada()).min().orElse(-1);
    }
}
