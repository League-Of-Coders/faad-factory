package com.app.core.widgets;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.frameworks.widget.Widget;
@Entity
@Table(name="Gallery")
public class Gallery extends Widget{

	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
