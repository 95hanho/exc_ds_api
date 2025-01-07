package me._hanho.ds.model;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "program_category")
public class ProgramCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cate_num;
	private String title;
	private String color;
	private String category_bg_url;
	
	private ArrayList<Program> list = new ArrayList<>();
	
	public ProgramCategory() {
		// TODO Auto-generated constructor stub
		
	}

	public ProgramCategory(int cate_num, String title, String color, String category_bg_url, ArrayList<Program> list) {
		super();
		this.cate_num = cate_num;
		this.title = title;
		this.color = color;
		this.category_bg_url = category_bg_url;
		this.list = list;
	}

	public int getCate_num() {
		return cate_num;
	}

	public void setCate_num(int cate_num) {
		this.cate_num = cate_num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory_bg_url() {
		return category_bg_url;
	}

	public void setCategory_bg_url(String category_bg_url) {
		this.category_bg_url = category_bg_url;
	}

	public ArrayList<Program> getList() {
		return list;
	}

	public void setList(ArrayList<Program> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ProgramCategory [cate_num=" + cate_num + ", title=" + title + ", color=" + color + ", category_bg_url="
				+ category_bg_url + ", list=" + list + "]";
	}
	
}
