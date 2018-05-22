package com.sample.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sample.model.PoneyBean;

public class PoneyDao {
	private List<PoneyBean> myPoneyList;
	private Random randomGenerator;
	
	public PoneyDao() {
		myPoneyList=new ArrayList<>();
		randomGenerator = new Random();
		createPoneyList();
	}

	private void createPoneyList() {
		
		PoneyBean p1=new PoneyBean("John", "pink", "super pink", "http://ekladata.com/9-cPSlYvrenNHMVawFmf_gLx8Jw.gif");
		PoneyBean p2=new PoneyBean("Roberto", "blue", "super lazy", "http://ekladata.com/JEVyY9DkwX4vVkakeBfikSyPROA.gif");
		PoneyBean p3=new PoneyBean("Anna", "pink", "super music girl", "http://ekladata.com/fMJl--_v-3CmisaynTHju1DMeXE.gif");
		PoneyBean p4=new PoneyBean("Angry Joe", "purple", "super angry power", "http://ekladata.com/AmbNNNvv-4YFEMZR8XD8e54WoHc.gif");
		PoneyBean p5=new PoneyBean("Ursula", "pink", "super cloning power", "http://ekladata.com/CXJhi2YLUbNz6__e0Ct6ZP-XOds.gif");
		
		myPoneyList.add(p1);
		myPoneyList.add(p2);
		myPoneyList.add(p3);
		myPoneyList.add(p4);
		myPoneyList.add(p5);
	}
	
	
	public List<PoneyBean> getPoneyList() {
		return this.myPoneyList;
	}
	
	public PoneyBean getPoneyByName(String name){
		for (PoneyBean poneyBean : myPoneyList) {
			if(poneyBean.getName().equals(name)){
				return poneyBean;
			}
		}
		return null;
	}
	
	public PoneyBean getRandomPoney(){
		int index=randomGenerator.nextInt(this.myPoneyList.size());
		return this.myPoneyList.get(index);
	}

	public void addPoney(String name, String superpower, String color, String image) {
		PoneyBean p1 = new PoneyBean(name, superpower, color, image);
		this.myPoneyList.add(p1);
	}

}
