import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;

public class CalculatorApp implements Listener{
	protected Shell shell;
	private Text textInput;
	private Text textResult;
	private List list;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CalculatorApp window = new CalculatorApp();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(504, 394);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite compositeCalculator = new Composite(shell, SWT.NONE);
		compositeCalculator.setLayout(new GridLayout(1, false));
		
		Composite compositeDisplay = new Composite(compositeCalculator, SWT.NONE);
		compositeDisplay.setLayout(new FillLayout(SWT.VERTICAL));
		GridData gd_compositeDisplay = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_compositeDisplay.heightHint = 85;
		gd_compositeDisplay.widthHint = 428;
		compositeDisplay.setLayoutData(gd_compositeDisplay);
		
		textInput = new Text(compositeDisplay, SWT.BORDER | SWT.READ_ONLY | SWT.RIGHT);
		textInput.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		
		textResult = new Text(compositeDisplay, SWT.BORDER | SWT.READ_ONLY | SWT.RIGHT);
		textResult.setText("0");
		textResult.setData("0");
		textResult.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		
		Composite compositeButtons = new Composite(compositeCalculator, SWT.NONE);
		compositeButtons.setLayout(new GridLayout(4, false));
		GridData gd_compositeButtons = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_compositeButtons.heightHint = 203;
		gd_compositeButtons.widthHint = 428;
		compositeButtons.setLayoutData(gd_compositeButtons);
		
		Button btnClearAllButton = new Button(compositeButtons, SWT.NONE);
		btnClearAllButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnClearAllButton.setText("CE");
		btnClearAllButton.setData("clear", "CE");
		checkData(btnClearAllButton);
		
		Button btnClearButton = new Button(compositeButtons, SWT.NONE);
		btnClearButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnClearButton.setText("C");
		btnClearButton.setData("clear", "C");
		checkData(btnClearButton);
		
		Button btnXButton = new Button(compositeButtons, SWT.NONE);
		btnXButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnXButton.setText("X");
		btnXButton.setData("clear", "X");
		checkData(btnXButton);
		
		Button btnDivisionButton = new Button(compositeButtons, SWT.NONE);
		btnDivisionButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnDivisionButton.setText("/");
		btnDivisionButton.setData("cal", "/");
		checkData(btnDivisionButton);
		
		Button btnNewButton_7 = new Button(compositeButtons, SWT.NONE);
		btnNewButton_7.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnNewButton_7.setText("7");
		btnNewButton_7.setData("num", "7");
		checkData(btnNewButton_7);
		
		Button btnNewButton_8 = new Button(compositeButtons, SWT.NONE);
		btnNewButton_8.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnNewButton_8.setText("8");
		btnNewButton_8.setData("num", "8");
		checkData(btnNewButton_8);
		
		Button btnNewButton_9 = new Button(compositeButtons, SWT.NONE);
		btnNewButton_9.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnNewButton_9.setText("9");
		btnNewButton_9.setData("num", "9");
		checkData(btnNewButton_9);
		
		Button btnMultiplicationButton = new Button(compositeButtons, SWT.NONE);
		btnMultiplicationButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnMultiplicationButton.setText("*");
		btnMultiplicationButton.setData("cal", "*");
		checkData(btnMultiplicationButton);
		
		Button btnNewButton_4 = new Button(compositeButtons, SWT.NONE);
		btnNewButton_4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnNewButton_4.setText("4");
		btnNewButton_4.setData("num", "4");
		checkData(btnNewButton_4);
		
		Button btnNewButton_5 = new Button(compositeButtons, SWT.NONE);
		btnNewButton_5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnNewButton_5.setText("5");
		btnNewButton_5.setData("num", "5");
		checkData(btnNewButton_5);
		
		Button btnNewButton_6 = new Button(compositeButtons, SWT.NONE);
		btnNewButton_6.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnNewButton_6.setText("6");
		btnNewButton_6.setData("num", "6");
		checkData(btnNewButton_6);
		
		Button btnSubstractionButton = new Button(compositeButtons, SWT.NONE);
		btnSubstractionButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnSubstractionButton.setText("-");
		btnSubstractionButton.setData("cal", "-");
		checkData(btnSubstractionButton);
		
		Button btnNewButton_1 = new Button(compositeButtons, SWT.NONE);
		btnNewButton_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnNewButton_1.setText("1");
		btnNewButton_1.setData("num", "1");
		checkData(btnNewButton_1);
		
		Button btnNewButton_2 = new Button(compositeButtons, SWT.NONE);
		btnNewButton_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnNewButton_2.setText("2");
		btnNewButton_2.setData("num", "2");
		checkData(btnNewButton_2);
		
		Button btnNewButton_3 = new Button(compositeButtons, SWT.NONE);
		btnNewButton_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnNewButton_3.setText("3");
		btnNewButton_3.setData("num", "3");
		checkData(btnNewButton_3);
		
		Button btnAdditionButton = new Button(compositeButtons, SWT.NONE);
		btnAdditionButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnAdditionButton.setText("+");
		btnAdditionButton.setData("cal", "+");
		checkData(btnAdditionButton);
		
		Button btnAddSubButton = new Button(compositeButtons, SWT.NONE);
		btnAddSubButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnAddSubButton.setText("+/-");
		btnAddSubButton.setData("modify", "+/-");
		checkData(btnAddSubButton);
		
		Button btnNewButton_0 = new Button(compositeButtons, SWT.NONE);
		btnNewButton_0.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnNewButton_0.setText("0");
		btnNewButton_0.setData("num", "0");
		checkData(btnNewButton_0);
		
		Button btnDotButton = new Button(compositeButtons, SWT.NONE);
		btnDotButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnDotButton.setText(".");
		btnDotButton.setData("modify", ".");
		checkData(btnDotButton);
		
		Button btnEqualButton = new Button(compositeButtons, SWT.NONE);
		btnEqualButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnEqualButton.setText("=");
		btnEqualButton.setData("equal","=");
		checkData(btnEqualButton);
		
		Composite compositeHistory = new Composite(shell, SWT.NONE);
		compositeHistory.setFont(SWTResourceManager.getFont("Segoe UI", 27, SWT.BOLD));
		compositeHistory.setLayout(new GridLayout(1, false));
		
		Label historyLabel = new Label(compositeHistory, SWT.NONE);
		historyLabel.setAlignment(SWT.CENTER);
		GridData gd_historyLabel = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_historyLabel.heightHint = 71;
		historyLabel.setLayoutData(gd_historyLabel);
		historyLabel.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		historyLabel.setBounds(0, 0, 55, 15);
		historyLabel.setText("History");
		
		list = new List(compositeHistory, SWT.BORDER);
		list.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		GridData gd_list = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_list.heightHint = 196;
		list.setLayoutData(gd_list);
		list.setBounds(0, 0, 71, 68);
		list.setItems(NO_HISTORY_MESS);
		list.addListener(SWT.MouseDown,this);
		
		Button btnClearHistoryButton = new Button(compositeHistory, SWT.NONE);
		GridData gd_btnClearHistoryButton = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_btnClearHistoryButton.heightHint = 82;
		btnClearHistoryButton.setLayoutData(gd_btnClearHistoryButton);
		btnClearHistoryButton.setBounds(0, 0, 75, 25);
		btnClearHistoryButton.setText("Clear");
		btnClearHistoryButton.setData("clearlist", "Clear");
		checkData(btnClearHistoryButton);
	}
	
	/**
	 * Global Variables
	 */
	double opt1 =0;
	double opt2 =0;
	int count1=1;
	int count2=1;
	int count = 16;
	boolean flagcal = false;
	boolean flagset = false;
	private static final String DIV_ZERO_MESS = "Cannot divide by 0";
	private static final String NO_HISTORY_MESS = "There's no history yet";
	private static final String PLUS = "+";
	private static final String MINUS = "-";
	private static final String MULTIPLY = "*";
	private static final String DIVIDE = "/";
	
	/**
	 * Methods
	 */
	public void checkData(Button btnNewButton) {
		btnNewButton.addListener(SWT.Selection, this);
	}

	@Override
	public void handleEvent(Event event) {
		if (event.type == SWT.Selection) {
			handleSelectionEvent(event);
		}
		else if (event.type == SWT.Modify) {
			handleSelectionEvent(event);
		}
		else if (event.type == SWT.MouseDown) {
			handleResultClick();
		}
	}

	private void handleResultClick() {
		int n = list.getSelectionIndex();
		String in = list.getItem(n);
		if(list.getItemCount()==1) {
			return;
		}
		if (n % 2 == 0) {
			textInput.setText(list.getItem(n));
			in = list.getItem(list.getSelectionIndex()+1);
		}
		else {
			textInput.setText(list.getItem(n-1));
		}
		textResult.setText(in);
		opt1 = Double.parseDouble(in);
		opt2 = 0;
		flagcal = false;
		flagset = false;
	}
	
	/**
	 * Handle Number
	 */
	public void resetAfterDiv0() {
		if (textInput.getText().contains(DIV_ZERO_MESS)) {
			flagcal = false;
			flagset = false;
			textInput.setText("");
		}
	}
	
	public void inputNumber(String eventID) {
		if(textResult.getText().equals("0") && eventID.equals("0")) {
			return;
		}
		//InputOpt1
		if ((!flagcal && !flagset) || (flagcal && !flagset)) {
			textResult.setText("");
			textResult.setText(eventID);
			}
		else if (!flagcal && flagset) {
			textResult.setText(textResult.getText() + eventID);
		}
		//InputOpt2
		else if (flagcal && flagset) {
			textResult.setText(textResult.getText() + eventID);
		}
		flagset = true;
	}
	
	public void displayE() {
		if (textResult.getText().length() == 17 && !textResult.getText().contains(".")) {
			textResult.setText(textResult.getText().substring(0,1) + "." + textResult.getText().substring(1) + "E" + count);
			count++;
			flagset = true;
			return;
		}
		if (textResult.getText().contains("E")) {
			textResult.setText(textResult.getText().substring(0,textResult.getText().indexOf("E")+1) + count);
			count++;
			flagset = true;
		}
	}
	
	public void handleNumber(String eventID) {
		resetAfterDiv0();
		//resetMaxDisplayLength()
		if (flagcal && !flagset) {
			count = 16;
		}
		//inputNumber
		inputNumber(eventID);
		//DisplayE
		displayE();
	}
	
	/**
	 * Handle Calculation
	 */
	public void getCalResult(String calchar, String eventID) {
		opt1 = Double.parseDouble(textInput.getText().substring(0, textInput.getText().length()-1));
		opt2 = Double.parseDouble(textResult.getText());
		Double res = 0.0;
		if (calchar.equals("+")) {
			res = opt1 + opt2;
		}
		else if (calchar.equals("-")) {
			res = opt1 - opt2;
		}
		else if (calchar.equals("*")) {
			res = opt1 * opt2;
		}
		else if (calchar.equals("/")) {
			if (opt2 == 0) {
				textInput.setText(DIV_ZERO_MESS);
				textResult.setText(DIV_ZERO_MESS);
				return;
			}
			res = opt1 / opt2;
		}
		String r = Double.toString(res);
		addToList(r, calchar);
		textInput.setText(r+eventID);
		opt1 = res;
		flagcal = true;
		flagset = false;
		opt2 = 0;
	}
	
	public void addToList(String r, String calchar) {
		list.add(textInput.getText().substring(0, textInput.getText().length()-1) + calchar + textResult.getText() + " = ");
		list.add(r);
	}
	
	public void calculateResult(String eventID) {
		clearNoHistoryMess();
		
		if(!flagset) {
			textInput.setText(textInput.getText().substring(0,textInput.getText().length()-1)+eventID);
			return;
		}
		
		if (textInput.getText().endsWith(PLUS)) {
			getCalResult(PLUS, eventID);
			return;
		}
		
		if (textInput.getText().endsWith(MINUS)) {
			getCalResult(MINUS, eventID);
			return;
		}
		
		if (textInput.getText().endsWith(MULTIPLY)) {
			getCalResult(MULTIPLY, eventID);
			return;
		}
		
		if (textInput.getText().endsWith("/")) {
			getCalResult(DIVIDE, eventID);
		}
	}
	
	public void handleCalculation(String eventID) {
		if (flagcal) {
			calculateResult(eventID);
		}
		else { 
			flagcal = true;
			flagset = false;
			textInput.setText(textResult.getText() + eventID);
		}
	}
	
	/**
	 * Handle Equal Sign
	 */
	public void clearNoHistoryMess() {
		if (list.indexOf(NO_HISTORY_MESS) != -1) {
			list.remove(NO_HISTORY_MESS);
		}
	}
	
	public void calculateWithoutCalChar(String r) {
		list.add(r + "=");
		list.add(r);
		textInput.setText(r+"=");
		flagcal = false;
		flagset = false;
	}
	
	public void equalWithoutCalChar() {
		if (textResult.getText().endsWith(".")) {
			String r = textResult.getText().substring(0,textResult.getText().length()-1);
			calculateWithoutCalChar(r);
		}
		else {
			String r = textResult.getText();
			calculateWithoutCalChar(r);
		}
	}
	
	public void getEqualCalResult(String calchar) {
		opt1 = Double.parseDouble(textInput.getText().substring(0, textInput.getText().length()-1));
		opt2 = Double.parseDouble(textResult.getText());
		Double res = 0.0;
		if (calchar.equals("+")) {
			res = opt1 + opt2;
		}
		else if (calchar.equals("-")) {
			res = opt1 - opt2;
		}
		else if (calchar.equals("*")) {
			res = opt1 * opt2;
		}
		else if (calchar.equals("/")) {
			if (opt2 == 0) {
				textInput.setText(DIV_ZERO_MESS);
				textResult.setText(DIV_ZERO_MESS);
				return;
			}
			res = opt1 / opt2;
		}
		String r = Double.toString(res);
		addToList(r, calchar);
		textInput.setText(textInput.getText().substring(0, textInput.getText().length()-1) + calchar + textResult.getText() + "=");
		textResult.setText(r);
		opt1 = res;
		flagcal = false;
		flagset = false;
	}
	
	public void handleEqualSign() {
		if (!flagset && textInput.getText().isEmpty()) {
			return;
		}
		
		if (!flagcal) {
			clearNoHistoryMess();
			equalWithoutCalChar();
			return;
		}
		
		if (flagcal) {
			clearNoHistoryMess();
			if (textInput.getText().endsWith("+")) {
				getEqualCalResult(PLUS);
				return;
			}
			
			if (textInput.getText().endsWith("-")) {
				getEqualCalResult(MINUS);
				return;
			}
			
			if (textInput.getText().endsWith("*")) {
				getEqualCalResult(MULTIPLY);
				return;
			}
			
			if (textInput.getText().endsWith("/")) {
				getEqualCalResult(DIVIDE);
			}
		}
	}
	
	/**
	 * Handle Clear Sign
	 */
	public void handleClearSign(String eventID) {
		if (eventID.equals("C")) {
			handleCSign();
		}
		if (eventID.equals("CE")) {
			handleCESign();
		}
		if (eventID.equals("X")) {
			handleXSign();
		}
	}
	
	public void handleCSign() {
		textInput.setText("");
		textResult.setText("0");
		flagcal = false;
		flagset = false;
		count = 16;
	}
	
	public void handleCESign() {
		if(textResult.getText().length() == 1 && textResult.getText().contains("0") && textInput.getText().isEmpty()) {
			return;
		}
		textResult.setText("0");
		flagset = false;	
		count = 16;
	}
	
	public void handleXSign() {
		if (textResult.getText().length() == 1) {
			textResult.setText("0");
			flagset = false;
			return;
		}
		if (textResult.getText().contains("E")) {
			int echarindex = textResult.getText().indexOf("E");
			count = Integer.parseInt(textResult.getText().substring(echarindex + 1));
			if (count < 16) {
				String numString = textResult.getText().substring(0,echarindex).replace(".", "");
				textResult.setText(numString);
				return;
			}
			count--;
			textResult.setText(textResult.getText().substring(0,textResult.getText().indexOf("E")+1) + count);
			return;
		}
		textResult.setText(textResult.getText().substring(0,textResult.getText().length()-1));
	}
	
	
	/**
	 * Handle Modify Sign
	 */
	public void handleModifySign(String eventID) {
		if (eventID.equals("+/-")) {
			handleAddSub();
		}
		if (eventID.equals(".")) {
			handleDot();
		}
	}
	
	public void handleAddSub() {
		if (textResult.getText().startsWith("-")) {
			textResult.setText(textResult.getText().substring(1));
		}
		else {
			textResult.setText("-" + textResult.getText());
		}
	}
	
	public void handleDot() {
		if (textResult.getText().contains(".")) {
			return;
		}
		if(textResult.getText().length()==1 && textResult.getText().contains("0")) {
			textResult.setText("0.");
		}
		else {
			textResult.setText(textResult.getText()+".");
		}
	}
	
	/**
	 * Clear history list method
	 */
	public void clearHistoryList() {
		list.removeAll();
		list.setItems(NO_HISTORY_MESS);
	}
	
	/**
	 * Handle Selection Method
	 * @param event
	 */
	private void handleSelectionEvent(Event event) {		
		String eventID = null;
		if (event.widget.getData("num") != null) {
			eventID = (String) event.widget.getData("num");
			// call hàm xử lý từ 1 đến 9
			handleNumber(eventID);
		}
		else if (event.widget.getData("clear") != null) {
			eventID = (String) event.widget.getData("clear");
			// call hàm xử lý clear
			handleClearSign(eventID);
		}
		else if (event.widget.getData("cal") != null) {
			eventID = (String) event.widget.getData("cal");
			// call hàm xử lý tính toán 
			handleCalculation(eventID);
		}
		else if (event.widget.getData("equal") != null) {
			handleEqualSign();
		}
		else if (event.widget.getData("modify") != null) {
			eventID = (String) event.widget.getData("modify");
			// call hàm xử lý đổi dấu và dấu "."
			handleModifySign(eventID);
		}
		else if (event.widget.getData("clearlist") != null) {
			eventID = (String) event.widget.getData("clearlist");
			if (eventID.equals("Clear")) {
				clearHistoryList();
			}
		}
		if (list.getItemCount() > 8) {
			for(int i = 0; i< 2; i++) {
				list.remove(0);
			}
		}
		if (list.getItemCount() == 0) {
			list.setItems(NO_HISTORY_MESS);
		}
	}
}
