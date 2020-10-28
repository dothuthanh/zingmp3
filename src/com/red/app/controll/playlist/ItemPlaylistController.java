package com.red.app.controll.playlist;

import com.red.app.App;
import com.red.app.helpers.FormatTime;
import com.red.app.media.Sound;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ItemPlaylistController {
	public Sound sound;

	@FXML
	public AnchorPane item;

	@FXML
	public ImageView thumb;
	@FXML
	public Label title;
	@FXML
	public Label duration;
	@FXML
	public Label artist;

	public void setSound(Sound sound) {
		this.sound = sound;
		this.title.setText(sound.getTitle());
		this.artist.setText(sound.getArtist());
		this.thumb.setImage(sound.getThumbnail());
		this.duration.setText(FormatTime.parse(sound.getSeconds()));

		item.getStyleClass().add("." + sound.getSEO());
	}

	@FXML
	public void handleClick() {
		App.homeController.PlaySound(this.sound);
	}

	@FXML
	public void handleEntered() {
		item.getStyleClass().add("itemPlaylisHover");
	}

	@FXML
	public void handleExited() {
		item.getStyleClass().clear();
		item.setStyle(null);
	}

	private void resetClass(){
		item.getStyleClass().add("bg_radius-10");
	}
}
