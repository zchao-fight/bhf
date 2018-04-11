package cn.ccf.pojo;

import java.util.ArrayList;
import java.util.List;

public class WorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("Type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("Type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("Type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("Type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("Type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("Type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("Type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("Type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("Type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("Content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("Content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("Content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("Content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("Content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("Content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("Content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("Content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("Content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("Content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("Content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("Content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("Content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("Content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andDigestIsNull() {
            addCriterion("Digest is null");
            return (Criteria) this;
        }

        public Criteria andDigestIsNotNull() {
            addCriterion("Digest is not null");
            return (Criteria) this;
        }

        public Criteria andDigestEqualTo(String value) {
            addCriterion("Digest =", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotEqualTo(String value) {
            addCriterion("Digest <>", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestGreaterThan(String value) {
            addCriterion("Digest >", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestGreaterThanOrEqualTo(String value) {
            addCriterion("Digest >=", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLessThan(String value) {
            addCriterion("Digest <", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLessThanOrEqualTo(String value) {
            addCriterion("Digest <=", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLike(String value) {
            addCriterion("Digest like", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotLike(String value) {
            addCriterion("Digest not like", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestIn(List<String> values) {
            addCriterion("Digest in", values, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotIn(List<String> values) {
            addCriterion("Digest not in", values, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestBetween(String value1, String value2) {
            addCriterion("Digest between", value1, value2, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotBetween(String value1, String value2) {
            addCriterion("Digest not between", value1, value2, "digest");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNull() {
            addCriterion("DepartmentID is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNotNull() {
            addCriterion("DepartmentID is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidEqualTo(Integer value) {
            addCriterion("DepartmentID =", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotEqualTo(Integer value) {
            addCriterion("DepartmentID <>", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThan(Integer value) {
            addCriterion("DepartmentID >", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DepartmentID >=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThan(Integer value) {
            addCriterion("DepartmentID <", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThanOrEqualTo(Integer value) {
            addCriterion("DepartmentID <=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIn(List<Integer> values) {
            addCriterion("DepartmentID in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotIn(List<Integer> values) {
            addCriterion("DepartmentID not in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidBetween(Integer value1, Integer value2) {
            addCriterion("DepartmentID between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotBetween(Integer value1, Integer value2) {
            addCriterion("DepartmentID not between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("CreateDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("CreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(String value) {
            addCriterion("CreateDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(String value) {
            addCriterion("CreateDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(String value) {
            addCriterion("CreateDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("CreateDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(String value) {
            addCriterion("CreateDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(String value) {
            addCriterion("CreateDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLike(String value) {
            addCriterion("CreateDate like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotLike(String value) {
            addCriterion("CreateDate not like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<String> values) {
            addCriterion("CreateDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<String> values) {
            addCriterion("CreateDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(String value1, String value2) {
            addCriterion("CreateDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(String value1, String value2) {
            addCriterion("CreateDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIsNull() {
            addCriterion("CreateUserID is null");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIsNotNull() {
            addCriterion("CreateUserID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuseridEqualTo(Integer value) {
            addCriterion("CreateUserID =", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotEqualTo(Integer value) {
            addCriterion("CreateUserID <>", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridGreaterThan(Integer value) {
            addCriterion("CreateUserID >", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("CreateUserID >=", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridLessThan(Integer value) {
            addCriterion("CreateUserID <", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridLessThanOrEqualTo(Integer value) {
            addCriterion("CreateUserID <=", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIn(List<Integer> values) {
            addCriterion("CreateUserID in", values, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotIn(List<Integer> values) {
            addCriterion("CreateUserID not in", values, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridBetween(Integer value1, Integer value2) {
            addCriterion("CreateUserID between", value1, value2, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("CreateUserID not between", value1, value2, "createuserid");
            return (Criteria) this;
        }

        public Criteria andIssueIsNull() {
            addCriterion("Issue is null");
            return (Criteria) this;
        }

        public Criteria andIssueIsNotNull() {
            addCriterion("Issue is not null");
            return (Criteria) this;
        }

        public Criteria andIssueEqualTo(Integer value) {
            addCriterion("Issue =", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotEqualTo(Integer value) {
            addCriterion("Issue <>", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueGreaterThan(Integer value) {
            addCriterion("Issue >", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueGreaterThanOrEqualTo(Integer value) {
            addCriterion("Issue >=", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLessThan(Integer value) {
            addCriterion("Issue <", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLessThanOrEqualTo(Integer value) {
            addCriterion("Issue <=", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueIn(List<Integer> values) {
            addCriterion("Issue in", values, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotIn(List<Integer> values) {
            addCriterion("Issue not in", values, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueBetween(Integer value1, Integer value2) {
            addCriterion("Issue between", value1, value2, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotBetween(Integer value1, Integer value2) {
            addCriterion("Issue not between", value1, value2, "issue");
            return (Criteria) this;
        }

        public Criteria andStickIsNull() {
            addCriterion("Stick is null");
            return (Criteria) this;
        }

        public Criteria andStickIsNotNull() {
            addCriterion("Stick is not null");
            return (Criteria) this;
        }

        public Criteria andStickEqualTo(Integer value) {
            addCriterion("Stick =", value, "stick");
            return (Criteria) this;
        }

        public Criteria andStickNotEqualTo(Integer value) {
            addCriterion("Stick <>", value, "stick");
            return (Criteria) this;
        }

        public Criteria andStickGreaterThan(Integer value) {
            addCriterion("Stick >", value, "stick");
            return (Criteria) this;
        }

        public Criteria andStickGreaterThanOrEqualTo(Integer value) {
            addCriterion("Stick >=", value, "stick");
            return (Criteria) this;
        }

        public Criteria andStickLessThan(Integer value) {
            addCriterion("Stick <", value, "stick");
            return (Criteria) this;
        }

        public Criteria andStickLessThanOrEqualTo(Integer value) {
            addCriterion("Stick <=", value, "stick");
            return (Criteria) this;
        }

        public Criteria andStickIn(List<Integer> values) {
            addCriterion("Stick in", values, "stick");
            return (Criteria) this;
        }

        public Criteria andStickNotIn(List<Integer> values) {
            addCriterion("Stick not in", values, "stick");
            return (Criteria) this;
        }

        public Criteria andStickBetween(Integer value1, Integer value2) {
            addCriterion("Stick between", value1, value2, "stick");
            return (Criteria) this;
        }

        public Criteria andStickNotBetween(Integer value1, Integer value2) {
            addCriterion("Stick not between", value1, value2, "stick");
            return (Criteria) this;
        }

        public Criteria andHighlightIsNull() {
            addCriterion("HighLight is null");
            return (Criteria) this;
        }

        public Criteria andHighlightIsNotNull() {
            addCriterion("HighLight is not null");
            return (Criteria) this;
        }

        public Criteria andHighlightEqualTo(Integer value) {
            addCriterion("HighLight =", value, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightNotEqualTo(Integer value) {
            addCriterion("HighLight <>", value, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightGreaterThan(Integer value) {
            addCriterion("HighLight >", value, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightGreaterThanOrEqualTo(Integer value) {
            addCriterion("HighLight >=", value, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightLessThan(Integer value) {
            addCriterion("HighLight <", value, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightLessThanOrEqualTo(Integer value) {
            addCriterion("HighLight <=", value, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightIn(List<Integer> values) {
            addCriterion("HighLight in", values, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightNotIn(List<Integer> values) {
            addCriterion("HighLight not in", values, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightBetween(Integer value1, Integer value2) {
            addCriterion("HighLight between", value1, value2, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightNotBetween(Integer value1, Integer value2) {
            addCriterion("HighLight not between", value1, value2, "highlight");
            return (Criteria) this;
        }

        public Criteria andPushIsNull() {
            addCriterion("Push is null");
            return (Criteria) this;
        }

        public Criteria andPushIsNotNull() {
            addCriterion("Push is not null");
            return (Criteria) this;
        }

        public Criteria andPushEqualTo(Integer value) {
            addCriterion("Push =", value, "push");
            return (Criteria) this;
        }

        public Criteria andPushNotEqualTo(Integer value) {
            addCriterion("Push <>", value, "push");
            return (Criteria) this;
        }

        public Criteria andPushGreaterThan(Integer value) {
            addCriterion("Push >", value, "push");
            return (Criteria) this;
        }

        public Criteria andPushGreaterThanOrEqualTo(Integer value) {
            addCriterion("Push >=", value, "push");
            return (Criteria) this;
        }

        public Criteria andPushLessThan(Integer value) {
            addCriterion("Push <", value, "push");
            return (Criteria) this;
        }

        public Criteria andPushLessThanOrEqualTo(Integer value) {
            addCriterion("Push <=", value, "push");
            return (Criteria) this;
        }

        public Criteria andPushIn(List<Integer> values) {
            addCriterion("Push in", values, "push");
            return (Criteria) this;
        }

        public Criteria andPushNotIn(List<Integer> values) {
            addCriterion("Push not in", values, "push");
            return (Criteria) this;
        }

        public Criteria andPushBetween(Integer value1, Integer value2) {
            addCriterion("Push between", value1, value2, "push");
            return (Criteria) this;
        }

        public Criteria andPushNotBetween(Integer value1, Integer value2) {
            addCriterion("Push not between", value1, value2, "push");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAttachfilesIsNull() {
            addCriterion("AttachFiles is null");
            return (Criteria) this;
        }

        public Criteria andAttachfilesIsNotNull() {
            addCriterion("AttachFiles is not null");
            return (Criteria) this;
        }

        public Criteria andAttachfilesEqualTo(String value) {
            addCriterion("AttachFiles =", value, "attachfiles");
            return (Criteria) this;
        }

        public Criteria andAttachfilesNotEqualTo(String value) {
            addCriterion("AttachFiles <>", value, "attachfiles");
            return (Criteria) this;
        }

        public Criteria andAttachfilesGreaterThan(String value) {
            addCriterion("AttachFiles >", value, "attachfiles");
            return (Criteria) this;
        }

        public Criteria andAttachfilesGreaterThanOrEqualTo(String value) {
            addCriterion("AttachFiles >=", value, "attachfiles");
            return (Criteria) this;
        }

        public Criteria andAttachfilesLessThan(String value) {
            addCriterion("AttachFiles <", value, "attachfiles");
            return (Criteria) this;
        }

        public Criteria andAttachfilesLessThanOrEqualTo(String value) {
            addCriterion("AttachFiles <=", value, "attachfiles");
            return (Criteria) this;
        }

        public Criteria andAttachfilesLike(String value) {
            addCriterion("AttachFiles like", value, "attachfiles");
            return (Criteria) this;
        }

        public Criteria andAttachfilesNotLike(String value) {
            addCriterion("AttachFiles not like", value, "attachfiles");
            return (Criteria) this;
        }

        public Criteria andAttachfilesIn(List<String> values) {
            addCriterion("AttachFiles in", values, "attachfiles");
            return (Criteria) this;
        }

        public Criteria andAttachfilesNotIn(List<String> values) {
            addCriterion("AttachFiles not in", values, "attachfiles");
            return (Criteria) this;
        }

        public Criteria andAttachfilesBetween(String value1, String value2) {
            addCriterion("AttachFiles between", value1, value2, "attachfiles");
            return (Criteria) this;
        }

        public Criteria andAttachfilesNotBetween(String value1, String value2) {
            addCriterion("AttachFiles not between", value1, value2, "attachfiles");
            return (Criteria) this;
        }

        public Criteria andCoverpageIsNull() {
            addCriterion("CoverPage is null");
            return (Criteria) this;
        }

        public Criteria andCoverpageIsNotNull() {
            addCriterion("CoverPage is not null");
            return (Criteria) this;
        }

        public Criteria andCoverpageEqualTo(String value) {
            addCriterion("CoverPage =", value, "coverpage");
            return (Criteria) this;
        }

        public Criteria andCoverpageNotEqualTo(String value) {
            addCriterion("CoverPage <>", value, "coverpage");
            return (Criteria) this;
        }

        public Criteria andCoverpageGreaterThan(String value) {
            addCriterion("CoverPage >", value, "coverpage");
            return (Criteria) this;
        }

        public Criteria andCoverpageGreaterThanOrEqualTo(String value) {
            addCriterion("CoverPage >=", value, "coverpage");
            return (Criteria) this;
        }

        public Criteria andCoverpageLessThan(String value) {
            addCriterion("CoverPage <", value, "coverpage");
            return (Criteria) this;
        }

        public Criteria andCoverpageLessThanOrEqualTo(String value) {
            addCriterion("CoverPage <=", value, "coverpage");
            return (Criteria) this;
        }

        public Criteria andCoverpageLike(String value) {
            addCriterion("CoverPage like", value, "coverpage");
            return (Criteria) this;
        }

        public Criteria andCoverpageNotLike(String value) {
            addCriterion("CoverPage not like", value, "coverpage");
            return (Criteria) this;
        }

        public Criteria andCoverpageIn(List<String> values) {
            addCriterion("CoverPage in", values, "coverpage");
            return (Criteria) this;
        }

        public Criteria andCoverpageNotIn(List<String> values) {
            addCriterion("CoverPage not in", values, "coverpage");
            return (Criteria) this;
        }

        public Criteria andCoverpageBetween(String value1, String value2) {
            addCriterion("CoverPage between", value1, value2, "coverpage");
            return (Criteria) this;
        }

        public Criteria andCoverpageNotBetween(String value1, String value2) {
            addCriterion("CoverPage not between", value1, value2, "coverpage");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}