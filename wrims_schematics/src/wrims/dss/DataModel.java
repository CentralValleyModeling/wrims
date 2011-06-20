package wrims.dss;

import hec.dssgui.Table;

//import java.util.NoSuchElementException;
//import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
//import javax.swing.table.TableColumnModel;

import hec.heclib.util.HecTime;

abstract class DataModel extends AbstractTableModel {
	protected boolean _isEditable = false;
	protected boolean _isExtendable = false;
	protected boolean _showCommas = false;
	protected boolean _pasteMode = false;
	protected StringBuffer _firstPasteError = null;
	protected DefaultTableCellRenderer _headerRenderer = null;
	protected DefaultTableCellRenderer _integerRenderer = null;
	protected DefaultTableCellRenderer _doubleRenderer = null;
	protected int _numberHeaderRows = 3;
	protected int _numberBlankRows = 0;

	public DataModel() {
		_headerRenderer = new DefaultTableCellRenderer();
		_headerRenderer.setHorizontalAlignment(0);
		_integerRenderer = new DefaultTableCellRenderer();
		_integerRenderer.setHorizontalAlignment(4);
		_doubleRenderer = new DefaultTableCellRenderer();
		_doubleRenderer.setHorizontalAlignment(4);
	}

	public void setEditable(boolean isEditable) {
		_isEditable = isEditable;
	}

	public void setExtendable(boolean extendable, int numberBlankRows) {
		_isExtendable = extendable;
		_numberBlankRows = numberBlankRows;
	}

	public void setPasteMode(boolean pasteMode) {
		_pasteMode = pasteMode;
		if (_pasteMode)
			_firstPasteError = new StringBuffer();
		else {
			if (_firstPasteError != null && _firstPasteError.length() > 2)
			JOptionPane.showMessageDialog(null, ("First Error: " + (Object) _firstPasteError),
					"Error during paste operation", 2);
			_firstPasteError = null;
		}
	}

	public void initializeEntryStartTime() {
		/* empty */
	}

	public Class<String> getColumnClass(int columnIndex) {
		return java.lang.String.class;
	}

	public Class<String> getSortColumnClass(int columnIndex) {
		return java.lang.String.class;
	}

	public Object getSortValueAt(int row, int column) {
		return getValueAt(row, column);
	}

	public void appendRows(int numberRows) {
		/* empty */
	}

	public boolean hasDataChanged() {
		return false;
	}

	public void saveAs(JFrame parent) {
		/* empty */
	}

	public void setCommas(boolean showCommas) {
		_showCommas = showCommas;
	}

	public boolean getCommas() {
		return _showCommas;
	}

	public void setNumberHeaderRows(int number) {
		_numberHeaderRows = number;
	}

	public int getNumberHeaderRows() {
		return _numberHeaderRows;
	}

	public void save(JFrame parent) {
		/* empty */
	}

	public void plot(JFrame parent) {
		/* empty */
	}

	public void setDecimalPosition(int position) {
		/* empty */
	}

	public int getDecimalPosition() {
		return -1;
	}

	public String getNominalName() {
		return "";
	}

	public String getName() {
		return "";
	}

	public int getDataColumnCount() {
		return 0;
	}

	public int updateContainers(int[] firstError) {
		return 0;
	}

	public int setValue(String value, int row, int column) {
		return 0;
	}

	public void setValueAt(Object value, int row, int column) {
		String svalue = value.toString().trim();
		String gvalue = getValueAt(row, column).toString().trim();
		if (!svalue.equals(gvalue)) setValue(svalue, row, column);
	}

	public boolean isPasteString(String pstring, int column) {
		if (pstring.length() > 50) return true;
		if (pstring.length() < 5) return false;
		byte[] bvalues = pstring.getBytes();
		boolean lpaste = false;
		int nperiod = 0;
		int nblanks = 0;
		for (int i = 0; i < bvalues.length; i++) {
			if (bvalues[i] == 9) {
				lpaste = true;
				break;
			}
			if (bvalues[i] == 10) {
				lpaste = true;
				break;
			}
			if (bvalues[i] == 32 && i > 0 && bvalues[i - 1] != 32) nblanks++;
			if (bvalues[i] == 46 && ++nperiod >= 2 && pstring.indexOf(",") > 0) {
				lpaste = true;
				break;
			}
		}
		if (lpaste) return true;
		if (nblanks > 0) {
			if (nblanks == 1 && bvalues.length < 11) {
				if (isQualityColumn(column) == true) lpaste = false;
				else lpaste = true;
			} else lpaste = true;
			if (lpaste && column < 2 && nblanks < 4) {
				HecTime hecTime = new HecTime(pstring);
				if (hecTime.isDefined()) lpaste = false;
			}
		}
		return lpaste;
	}

	protected boolean isQualityColumn(int column) {
		return false;
	}

	protected int[] getNextEditableCell(int row, int column) {
		int ncolumns = getColumnCount();
		int nrows = getRowCount();
		int[] next = new int[2];
		if (++column < ncolumns) {
			for (int i = column; i < ncolumns; i++) {
				if (isCellEditable(row, i)) {
					next[0] = row;
					next[1] = i;
					return next;
				}
			}
		}
		if (++row >= nrows) return null;
		for (int r = row; r < nrows; r++) {
			for (int c = 0; c < ncolumns; c++) {
				if (isCellEditable(r, c)) {
					next[0] = r;
					next[1] = c;
					return next;
				}
			}
		}
		next = null;
		return null;
	}

	public String getSelectedDataString(int minRow, int maxRow, int minColumn, int maxColumn) {
		int nRows = maxRow - minRow + 1;
		int nColumns = maxColumn - minColumn + 1;
		StringBuffer dataString = new StringBuffer(nRows * nColumns * 8);
		if (minRow == 0) dataString.append(getColumnHeaderString());
		for (int i = minRow; i < maxRow + 1; i++) {
			for (int j = minColumn; j < maxColumn + 1; j++) {
				dataString.append(getValueAt(i, j));
				if (j < maxColumn) dataString.append(" \t");
			}
			if (i < maxRow) dataString.append('\n');
		}
		return dataString.toString();
	}

	public String allDataString() {
		int nRows = getRowCount();
		int nColumns = getColumnCount();
		StringBuffer dataString = new StringBuffer(nRows * nColumns * 8);
		dataString.append(getColumnHeaderString());
		dataString.append('\n');
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nColumns; j++) {
				dataString.append(getValueAt(i, j));
				if (j < nColumns - 1) dataString.append(" \t");
			}
			if (i < nRows - 1)
			dataString.append('\n');
		}
		return dataString.toString();
	}

	protected String getColumnHeaderString() {
		StringBuffer headerString = new StringBuffer();
		int nColumns = getColumnCount();
		Vector[] headers = new Vector[nColumns];
		int maxLines = 0;
		for (int j = 0; j < nColumns; j++) {
			headers[j] = new Vector();
			String header = getColumnName(j) + "\n";
			int k = 0;
			int max = 0;
			int position = 0;
			while (k >= 0) {
				k = header.indexOf("\n", position);
				if (k > 0) {
					if (k - position > 0)
					headers[j].add(header.substring(position, k));
					else
					headers[j].add("");
					position = k + 1;
					max++;
				}
			}
			if (max > maxLines) maxLines = max;
		}
		for (int i = 0; i < maxLines; i++) {
			for (int j = 0; j < nColumns; j++) {
				if (headers[j].size() > i)
					headerString.append((String) headers[j].elementAt(i));
				if (j < nColumns - 1)
					headerString.append("\t");
				else
					headerString.append("\n");
			}
		}
		return headerString.toString();
	}

	protected TableCellRenderer getCellRenderer(Table table, int row, int column) {
		return null;
	}

/*	public void setColumnWidths(TableColumnModel columnModel) {
	} */

/*	public String print() {
		int rows = getRowCount();
		int columns = getColumnCount();
		String line = '\t' + getNominalName();
		String s = fillTabs(line) + '\n';
		line = "";
		for (int j = 0; j < columns; j++)
			line += '\t' + getColumnName(j);
		s += fillTabs(line) + '\n';
		for (int i = 0; i < rows; i++) {
			line = "";
			for (int j = 0; j < columns; j++)
			line += '\t' + getValueAt(i, j).toString();
			s += fillTabs(line) + '\n';
		}
		return s;
	} */

/*	public String fillTabs(String line) {
		String answer = "";
		StringTokenizer parser = new StringTokenizer(line, "\t", true);
		int number = parser.countTokens();
		try {
			for (int i = 0; i < number; i++) {
			String token = parser.nextToken();
			if (token.equals("\t"))
				answer += tabPos(answer.length());
			else
				answer += (String) token;
			}
		} catch (NoSuchElementException nosuchelementexception) {
		}
		return answer;
	} */

/*	public String tabPos(int position) {
		String blanks = "                  ";
		if (position < 3) {
			int diff = 3 - position;
			return blanks.substring(0, diff);
		}
		int loc = position / 15;
		loc *= 15;
		int diff = 15 - (position - loc);
		return blanks.substring(0, diff);
	} */
}
