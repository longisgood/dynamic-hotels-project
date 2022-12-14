package hotelList;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class GijangController implements Initializable {

	@FXML
	private CheckBox cb1, cb2, cb3;
	@FXML
	private Button btncon, btnback;
	@FXML
	private ImageView BLHhotel, BDhotel, Hhotel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btncon.setOnAction(e -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			if (cb1.isSelected() == true && cb2.isSelected() == false && cb3.isSelected() == false) {
				move("/hotelRoom/Gijang/BLHHotel.fxml", BLHhotel);
			} else if (cb2.isSelected() == true && cb1.isSelected() == false && cb3.isSelected() == false) {
				move("/hotelRoom/Gijang/BrownDotHotel.fxml", BDhotel);
			} else if (cb3.isSelected() == true && cb2.isSelected() == false && cb1.isSelected() == false) {
				move("/hotelRoom/Gijang/HoundHotel.fxml", Hhotel);
			} else {
				alert.setTitle("중복 선택 알림창");
				alert.setHeaderText("**다시 선택해주시길 바랍니다.**");
				alert.setContentText("선택하지 않거나 2개이상의 호텔을 중복 선택하셨습니다.\n본 예약은 다중 예약을 지원하지 않습니다.");
				alert.show();
				cb1.setSelected(false);
				cb2.setSelected(false);
				cb3.setSelected(false);
			}
		});

		btnback.setOnAction(e -> {
			back("../choice/Choice.fxml", btnback);
		});

	}

	private void move(String location, ImageView hotel) {
		Stage stage = new Stage();
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource(location));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		stage = (Stage) hotel.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();

	}

	private void back(String location, Button btnback) {
		Stage stage = new Stage();
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource(location));
		} catch (IOException e1) {
		}
		stage = (Stage) btnback.getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();

	}

}
