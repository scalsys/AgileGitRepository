package org.scalsys.agile.model;

// Generated Jul 23, 2013 11:53:16 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Idea generated by hbm2java
 */
@Entity
@Table(name = "idea", catalog = "exo_platform_idm")
public class Idea implements java.io.Serializable {

	private long ideaId;
	private IdeaVote ideaVote;
	private Contest contest;
	private IdeaType ideaType;
	private IdeaSubcategory ideaSubcategory;
	private IdeaCategory ideaCategory;
	private String ideaTitle;
	private String description;
	private boolean isDeleted;
	private Date submissionDate;
	private Date updatedDate;
	private String stage;
	private long coinventorId;
	private Set ideaDescriptorFiles = new HashSet(0);

	public Idea() {
		this(0);
	}

	public Idea(long ideaId) {
		
	}

	public Idea(long ideaId, IdeaType ideaType,
			IdeaSubcategory ideaSubcategory, IdeaCategory ideaCategory,
			String ideaTitle, boolean isDeleted, Date submissionDate,
			String stage, long coinventorId) {
		this.ideaId = ideaId;
		this.ideaType = ideaType;
		this.ideaSubcategory = ideaSubcategory;
		this.ideaCategory = ideaCategory;
		this.ideaTitle = ideaTitle;
		this.isDeleted = isDeleted;
		this.submissionDate = submissionDate;
		this.stage = stage;
		this.coinventorId = coinventorId;
	}

	public Idea(long ideaId, IdeaVote ideaVote, Contest contest,
			IdeaType ideaType, IdeaSubcategory ideaSubcategory,
			IdeaCategory ideaCategory, String ideaTitle, String description,
			boolean isDeleted, Date submissionDate, Date updatedDate,
			String stage, long coinventorId, Set ideaDescriptorFiles) {
		this.ideaId = ideaId;
		this.ideaVote = ideaVote;
		this.contest = contest;
		this.ideaType = ideaType;
		this.ideaSubcategory = ideaSubcategory;
		this.ideaCategory = ideaCategory;
		this.ideaTitle = ideaTitle;
		this.description = description;
		this.isDeleted = isDeleted;
		this.submissionDate = submissionDate;
		this.updatedDate = updatedDate;
		this.stage = stage;
		this.coinventorId = coinventorId;
		this.ideaDescriptorFiles = ideaDescriptorFiles;
	}

	@Id
	@Column(name = "idea_id", unique = true, nullable = false)
	public long getIdeaId() {
		return this.ideaId;
	}

	public void setIdeaId(long ideaId) {
		this.ideaId = ideaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vote_id")
	public IdeaVote getIdeaVote() {
		return this.ideaVote;
	}

	public void setIdeaVote(IdeaVote ideaVote) {
		this.ideaVote = ideaVote;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contest_id")
	public Contest getContest() {
		return this.contest;
	}

	public void setContest(Contest contest) {
		this.contest = contest;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idea_type_id", nullable = false)
	public IdeaType getIdeaType() {
		return this.ideaType;
	}

	public void setIdeaType(IdeaType ideaType) {
		this.ideaType = ideaType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subcategory_id", nullable = false)
	public IdeaSubcategory getIdeaSubcategory() {
		return this.ideaSubcategory;
	}

	public void setIdeaSubcategory(IdeaSubcategory ideaSubcategory) {
		this.ideaSubcategory = ideaSubcategory;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public IdeaCategory getIdeaCategory() {
		return this.ideaCategory;
	}

	public void setIdeaCategory(IdeaCategory ideaCategory) {
		this.ideaCategory = ideaCategory;
	}

	@Column(name = "idea_title", nullable = false)
	public String getIdeaTitle() {
		return this.ideaTitle;
	}

	public void setIdeaTitle(String ideaTitle) {
		this.ideaTitle = ideaTitle;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "is_deleted", nullable = false)
	public boolean isIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "submission_date", nullable = false, length = 19)
	public Date getSubmissionDate() {
		return this.submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "stage", nullable = false, length = 20)
	public String getStage() {
		return this.stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	@Column(name = "coinventor_id", nullable = false)
	public long getCoinventorId() {
		return this.coinventorId;
	}

	public void setCoinventorId(long coinventorId) {
		this.coinventorId = coinventorId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idea")
	public Set getIdeaDescriptorFiles() {
		return this.ideaDescriptorFiles;
	}

	public void setIdeaDescriptorFiles(Set ideaDescriptorFiles) {
		this.ideaDescriptorFiles = ideaDescriptorFiles;
	}

}
