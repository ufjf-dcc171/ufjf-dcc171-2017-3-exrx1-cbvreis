
package descricaolatitude;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class EventosListModel implements ListModel<Eventos> {
    private final ArrayList<Eventos> eventos;
    private List<ListDataListener> dataListeners = new ArrayList<>();

    EventosListModel(ArrayList<Eventos> listaExemplo) {
        this.eventos = listaExemplo;
    }
    @Override
    public int getSize() {
        return eventos.size();
    }

    @Override
    public Eventos getElementAt(int index) {
        return eventos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        dataListeners.remove(l);
    }
}
