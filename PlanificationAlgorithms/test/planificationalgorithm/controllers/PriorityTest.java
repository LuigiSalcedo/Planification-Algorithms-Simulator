package planificationalgorithm.controllers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import planificationalgorithms.controllers.ProcessesController;
import planificationalgorithms.models.Process;

/**
 *
 * @author Luigi Salcedo
 */
public class PriorityTest {
    
    private static ProcessesController controller;
    
    public static void main(String[] args) {
        LinkedList<Process> list = new LinkedList<>();
        
        Process a = new Process("A", 0, 6, 1);
        Process b = new Process("B", 1, 3, 2);
        Process c = new Process("C", 3, 4, 1);
        Process d = new Process("D", 4, 2, 3);
        Process e = new Process("E", 6, 1, 1);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        HashMap<Integer, Process> map = new HashMap<>();
        for(Process p : list) {
            map.put(p.gettLlegada(), p);
        }
        controller = new ProcessesController(map);
        var r = controller.PriorityAlgorithm();
        r.sort(Comparator.comparing(Process::getNombre));
        for(Process p : r) {
            System.out.println(p);
        }
                
    }
}
