package org.herac.tuxguitar.InstaShred;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import com.welie.blessed.*;

// Defines how the Bluetooth Table behaves
public class BLETableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private Map<String, BluetoothPeripheral> map;
	
	// Set the map to whatever is passed to this table model
	public BLETableModel(Map<String, BluetoothPeripheral> peripheralmap) {
		this.map = (Map<String, BluetoothPeripheral>) peripheralmap;
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return map.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int i = 0;
        for (Entry<String, BluetoothPeripheral> entry : map.entrySet()) {
            if (i == rowIndex) {
                if (columnIndex == 0) {
                	// This is the BLE address
                    return entry.getKey();
                } else {
                	// This is the device name
                    return entry.getValue().getName();
                }
            }
            i++;
        }
        return null;
	}
	
	@Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Bluetooth Address";
        } else {
            return "Device Name";
        }
    }
}
