package com.springmvc.mvcdemo.model;

import java.net.Inet4Address;
import java.util.List;

public class CourseDemo {

	// 课程Id
	private Integer courseId;
	// 课程名称
	private String title;
	// 图片路径
	private String imgPath;
	// 学习人数
	private Integer learningNum;
	// 课程时长
	private Long duration;
	// 课程难度
	private Integer level;
	// 课程难度描述
	private String levelDesc;
	// 课程介绍
	private String descr;
	// 课程提钢
	private List<ChapterDemo> chapterList;

	public CourseDemo() {
		super();
	}

	public CourseDemo(Integer courseId, String title, String imgPath, Integer learningNum, Long duration, Integer level,
			String levelDesc, String descr, List<ChapterDemo> chapterList) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.imgPath = imgPath;
		this.learningNum = learningNum;
		this.duration = duration;
		this.level = level;
		this.levelDesc = levelDesc;
		this.descr = descr;
		this.chapterList = chapterList;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getLearningNum() {
		return learningNum;
	}

	public void setLearningNum(Integer learningNum) {
		this.learningNum = learningNum;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getLevelDesc() {
		return levelDesc;
	}

	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public List<ChapterDemo> getChapterList() {
		return chapterList;
	}

	public void setChapterList(List<ChapterDemo> chapterList) {
		this.chapterList = chapterList;
	}

}
