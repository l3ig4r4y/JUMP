package com.leiskies.app.bj21.utilities;

import com.leiskies.app.bj21.enums.Render;
import com.leiskies.app.bj21.enums.Show;
import com.leiskies.app.bj21.enums.Size;

public class Settings {
	private Size size;
	private Render render;
	private Show show;
	private Settings(Size size, Render render, Show show) {
		super();
		this.size = size;
		this.render = render;
		this.show = show;
	}
	private Settings(Size size, Render render) {
		super();
		this.size = size;
		this.render = render;
	}
	private Settings(Size size) {
		super();
		this.size = size;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Render getRender() {
		return render;
	}
	public void setRender(Render render) {
		this.render = render;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	@Override
	public String toString() {
		return "Settings [size=" + size + ", render=" + render + ", show=" + show + "]";
	}
	
}
