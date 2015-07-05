package mx.gob.tabasco.seguro.views;

import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;


import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;
import mx.gob.tabasco.seguro.MainApp;
import mx.gob.tabasco.seguro.model.Asegurado;
import mx.gob.tabasco.seguro.util.AseguradoWebService;

public class AseguradoOverviewController {
	
	
	@FXML
    private TableView<Asegurado> aseguradoTable;
	@FXML
    private TableColumn<Asegurado, String> nombreColumn;
	@FXML
    private TableColumn<Asegurado, String> apellidosColumn;
	@FXML
    private TableColumn<Asegurado, Number> edadColumn;
	@FXML
    private TableColumn<Asegurado, String> sexoColumn;
	@FXML
    private TableColumn<Asegurado, String> numeroSeguroColumn;
	
	@FXML
	private Label nombreLabel;
	@FXML
	private Label apellidosLabel;
	@FXML
	private Label edadLabel;
	@FXML
	private Label sexoLabel;
	@FXML
	private Label numeroSeguroLabel;
	
	
	
	@SuppressWarnings("unused")
	private MainApp mainApp;
	private ObservableList<Asegurado> aseguradoData; 
	
	public AseguradoOverviewController() {
		
	}
	

	
	private void loadTablaAsegurado(){
		aseguradoTable.getItems().clear();
		aseguradoTable.setItems(aseguradoData);
		nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
		apellidosColumn.setCellValueFactory(cellData -> cellData.getValue().apellidoProperty());
		edadColumn.setCellValueFactory(cellData -> cellData.getValue().edadProperty());
		sexoColumn.setCellValueFactory(cellData -> cellData.getValue().sexoProperty());
		sexoColumn.setCellFactory(new Callback<TableColumn<Asegurado,String>, TableCell<Asegurado,String>>() {
			@Override
			public TableCell<Asegurado, String> call( TableColumn<Asegurado, String> param) {
				final TableCell<Asegurado, String> cell = new TableCell<Asegurado, String>() {
					private Text text;
					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (!isEmpty()) {
							if(item.toString().trim().equals("M")){
								text = new Text("Masculino");
							}else if(item.toString().trim().equals("F")){
								text = new Text("Femenino");
							}else{
								text = new Text("");
							}
							setGraphic(text);
						}else{
							text = new Text("");
							setGraphic(text);
						}
					}
				};
				return cell;
			}
		});
		numeroSeguroColumn.setCellValueFactory(cellData -> cellData.getValue().numeroSeguroSocialProperty());
		aseguradoTable.setOnMousePressed(new EventHandler<MouseEvent>() {
    	    @Override 
    	    public void handle(MouseEvent event) {
    	        if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
    	        	handleLabelSeletcAsegurado();                   
    	        }
    	    }
    	});
	}
	
	private void handleLabelSeletcAsegurado(){
		Asegurado asegurado = aseguradoTable.getSelectionModel().getSelectedItem();
		nombreLabel.setText(asegurado.getNombre());
		apellidosLabel.setText(asegurado.getApellido());
		edadLabel.setText(Integer.toString(asegurado.getEdad()));
		sexoLabel.setText(asegurado.getSexo());
		numeroSeguroLabel.setText(asegurado.getNumeroSeguroSocial());
	}
	
	@FXML
	private void handleEditar(){
		Asegurado asegurado = aseguradoTable.getSelectionModel().getSelectedItem();
		if(asegurado!=null){
			boolean ok = mainApp.showFormEditarAsegurado(asegurado);	    	
		}else{
			Dialogs.create()
            .title("Aviso")
            .masthead("No existe asegurado seleccionado.")
            .message("Porfavor seleccione un asegurado.")
            .showWarning();
		}
	}
	@FXML
	private void handleEliminar(){
		Asegurado asegurado = aseguradoTable.getSelectionModel().getSelectedItem();
		if(asegurado!=null){
			Action response = Dialogs.create()	    	 
	    	        .title("Eliminar Asegurado")
	    	        .masthead("Se procedera a eliminar el assegurado"+asegurado.getNombre()+" "+asegurado.getApellido()+" con el No. de Seguro "+asegurado.getNumeroSeguroSocial()+" seleccionado.")
	    	        .message("�Deseas continuar?")
	    	        .showConfirm();

	    	if (response == Dialog.Actions.YES) {
	    		
	    		AseguradoWebService ws = new AseguradoWebService();
				boolean ok = ws.eliminarAsegurado(asegurado);
				if(ok){
					aseguradoTable.getItems().remove(aseguradoTable.getSelectionModel().getSelectedIndex());					
					
					aseguradoData.remove(asegurado);
					Dialogs.create()
		            .title("Aviso")
		            .masthead("Se elimino de forma correcta.")
		            .message("")
		            .showInformation();
				}
				
	    	} 
		}else{
			Dialogs.create()
            .title("Aviso")
            .masthead("No existe asegurado seleccionado.")
            .message("Porfavor seleccione un asegurado.")
            .showWarning();
		}
	}
	
	@FXML
    private void initialize(){
		
    }
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        aseguradoData = mainApp.getAsegurdosData();
        
        AseguradoWebService ws = new AseguradoWebService();
		ws.loadAsegurados(aseguradoData);
		loadTablaAsegurado();
    }

}
