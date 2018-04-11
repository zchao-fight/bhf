package cn.ccf.pojo;

import java.util.ArrayList;
import java.util.List;

public class DutyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DutyExample() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLeadernameIsNull() {
            addCriterion("LeaderName is null");
            return (Criteria) this;
        }

        public Criteria andLeadernameIsNotNull() {
            addCriterion("LeaderName is not null");
            return (Criteria) this;
        }

        public Criteria andLeadernameEqualTo(String value) {
            addCriterion("LeaderName =", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameNotEqualTo(String value) {
            addCriterion("LeaderName <>", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameGreaterThan(String value) {
            addCriterion("LeaderName >", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameGreaterThanOrEqualTo(String value) {
            addCriterion("LeaderName >=", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameLessThan(String value) {
            addCriterion("LeaderName <", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameLessThanOrEqualTo(String value) {
            addCriterion("LeaderName <=", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameLike(String value) {
            addCriterion("LeaderName like", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameNotLike(String value) {
            addCriterion("LeaderName not like", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameIn(List<String> values) {
            addCriterion("LeaderName in", values, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameNotIn(List<String> values) {
            addCriterion("LeaderName not in", values, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameBetween(String value1, String value2) {
            addCriterion("LeaderName between", value1, value2, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameNotBetween(String value1, String value2) {
            addCriterion("LeaderName not between", value1, value2, "leadername");
            return (Criteria) this;
        }

        public Criteria andAdvisernameIsNull() {
            addCriterion("AdviserName is null");
            return (Criteria) this;
        }

        public Criteria andAdvisernameIsNotNull() {
            addCriterion("AdviserName is not null");
            return (Criteria) this;
        }

        public Criteria andAdvisernameEqualTo(String value) {
            addCriterion("AdviserName =", value, "advisername");
            return (Criteria) this;
        }

        public Criteria andAdvisernameNotEqualTo(String value) {
            addCriterion("AdviserName <>", value, "advisername");
            return (Criteria) this;
        }

        public Criteria andAdvisernameGreaterThan(String value) {
            addCriterion("AdviserName >", value, "advisername");
            return (Criteria) this;
        }

        public Criteria andAdvisernameGreaterThanOrEqualTo(String value) {
            addCriterion("AdviserName >=", value, "advisername");
            return (Criteria) this;
        }

        public Criteria andAdvisernameLessThan(String value) {
            addCriterion("AdviserName <", value, "advisername");
            return (Criteria) this;
        }

        public Criteria andAdvisernameLessThanOrEqualTo(String value) {
            addCriterion("AdviserName <=", value, "advisername");
            return (Criteria) this;
        }

        public Criteria andAdvisernameLike(String value) {
            addCriterion("AdviserName like", value, "advisername");
            return (Criteria) this;
        }

        public Criteria andAdvisernameNotLike(String value) {
            addCriterion("AdviserName not like", value, "advisername");
            return (Criteria) this;
        }

        public Criteria andAdvisernameIn(List<String> values) {
            addCriterion("AdviserName in", values, "advisername");
            return (Criteria) this;
        }

        public Criteria andAdvisernameNotIn(List<String> values) {
            addCriterion("AdviserName not in", values, "advisername");
            return (Criteria) this;
        }

        public Criteria andAdvisernameBetween(String value1, String value2) {
            addCriterion("AdviserName between", value1, value2, "advisername");
            return (Criteria) this;
        }

        public Criteria andAdvisernameNotBetween(String value1, String value2) {
            addCriterion("AdviserName not between", value1, value2, "advisername");
            return (Criteria) this;
        }

        public Criteria andOpertornameIsNull() {
            addCriterion("OpertorName is null");
            return (Criteria) this;
        }

        public Criteria andOpertornameIsNotNull() {
            addCriterion("OpertorName is not null");
            return (Criteria) this;
        }

        public Criteria andOpertornameEqualTo(String value) {
            addCriterion("OpertorName =", value, "opertorname");
            return (Criteria) this;
        }

        public Criteria andOpertornameNotEqualTo(String value) {
            addCriterion("OpertorName <>", value, "opertorname");
            return (Criteria) this;
        }

        public Criteria andOpertornameGreaterThan(String value) {
            addCriterion("OpertorName >", value, "opertorname");
            return (Criteria) this;
        }

        public Criteria andOpertornameGreaterThanOrEqualTo(String value) {
            addCriterion("OpertorName >=", value, "opertorname");
            return (Criteria) this;
        }

        public Criteria andOpertornameLessThan(String value) {
            addCriterion("OpertorName <", value, "opertorname");
            return (Criteria) this;
        }

        public Criteria andOpertornameLessThanOrEqualTo(String value) {
            addCriterion("OpertorName <=", value, "opertorname");
            return (Criteria) this;
        }

        public Criteria andOpertornameLike(String value) {
            addCriterion("OpertorName like", value, "opertorname");
            return (Criteria) this;
        }

        public Criteria andOpertornameNotLike(String value) {
            addCriterion("OpertorName not like", value, "opertorname");
            return (Criteria) this;
        }

        public Criteria andOpertornameIn(List<String> values) {
            addCriterion("OpertorName in", values, "opertorname");
            return (Criteria) this;
        }

        public Criteria andOpertornameNotIn(List<String> values) {
            addCriterion("OpertorName not in", values, "opertorname");
            return (Criteria) this;
        }

        public Criteria andOpertornameBetween(String value1, String value2) {
            addCriterion("OpertorName between", value1, value2, "opertorname");
            return (Criteria) this;
        }

        public Criteria andOpertornameNotBetween(String value1, String value2) {
            addCriterion("OpertorName not between", value1, value2, "opertorname");
            return (Criteria) this;
        }

        public Criteria andPredateIsNull() {
            addCriterion("PreDate is null");
            return (Criteria) this;
        }

        public Criteria andPredateIsNotNull() {
            addCriterion("PreDate is not null");
            return (Criteria) this;
        }

        public Criteria andPredateEqualTo(String value) {
            addCriterion("PreDate =", value, "predate");
            return (Criteria) this;
        }

        public Criteria andPredateNotEqualTo(String value) {
            addCriterion("PreDate <>", value, "predate");
            return (Criteria) this;
        }

        public Criteria andPredateGreaterThan(String value) {
            addCriterion("PreDate >", value, "predate");
            return (Criteria) this;
        }

        public Criteria andPredateGreaterThanOrEqualTo(String value) {
            addCriterion("PreDate >=", value, "predate");
            return (Criteria) this;
        }

        public Criteria andPredateLessThan(String value) {
            addCriterion("PreDate <", value, "predate");
            return (Criteria) this;
        }

        public Criteria andPredateLessThanOrEqualTo(String value) {
            addCriterion("PreDate <=", value, "predate");
            return (Criteria) this;
        }

        public Criteria andPredateLike(String value) {
            addCriterion("PreDate like", value, "predate");
            return (Criteria) this;
        }

        public Criteria andPredateNotLike(String value) {
            addCriterion("PreDate not like", value, "predate");
            return (Criteria) this;
        }

        public Criteria andPredateIn(List<String> values) {
            addCriterion("PreDate in", values, "predate");
            return (Criteria) this;
        }

        public Criteria andPredateNotIn(List<String> values) {
            addCriterion("PreDate not in", values, "predate");
            return (Criteria) this;
        }

        public Criteria andPredateBetween(String value1, String value2) {
            addCriterion("PreDate between", value1, value2, "predate");
            return (Criteria) this;
        }

        public Criteria andPredateNotBetween(String value1, String value2) {
            addCriterion("PreDate not between", value1, value2, "predate");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("Type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("Type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("Type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("Type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("Type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("Type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("Type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("Type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("Type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("Type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("Type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("StartTime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("StartTime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(String value) {
            addCriterion("StartTime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(String value) {
            addCriterion("StartTime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(String value) {
            addCriterion("StartTime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("StartTime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(String value) {
            addCriterion("StartTime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(String value) {
            addCriterion("StartTime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLike(String value) {
            addCriterion("StartTime like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotLike(String value) {
            addCriterion("StartTime not like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<String> values) {
            addCriterion("StartTime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<String> values) {
            addCriterion("StartTime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(String value1, String value2) {
            addCriterion("StartTime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(String value1, String value2) {
            addCriterion("StartTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("EndTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("EndTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(String value) {
            addCriterion("EndTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(String value) {
            addCriterion("EndTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(String value) {
            addCriterion("EndTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("EndTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(String value) {
            addCriterion("EndTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(String value) {
            addCriterion("EndTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLike(String value) {
            addCriterion("EndTime like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotLike(String value) {
            addCriterion("EndTime not like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<String> values) {
            addCriterion("EndTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<String> values) {
            addCriterion("EndTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(String value1, String value2) {
            addCriterion("EndTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(String value1, String value2) {
            addCriterion("EndTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andContactinfoIsNull() {
            addCriterion("ContactInfo is null");
            return (Criteria) this;
        }

        public Criteria andContactinfoIsNotNull() {
            addCriterion("ContactInfo is not null");
            return (Criteria) this;
        }

        public Criteria andContactinfoEqualTo(String value) {
            addCriterion("ContactInfo =", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoNotEqualTo(String value) {
            addCriterion("ContactInfo <>", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoGreaterThan(String value) {
            addCriterion("ContactInfo >", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoGreaterThanOrEqualTo(String value) {
            addCriterion("ContactInfo >=", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoLessThan(String value) {
            addCriterion("ContactInfo <", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoLessThanOrEqualTo(String value) {
            addCriterion("ContactInfo <=", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoLike(String value) {
            addCriterion("ContactInfo like", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoNotLike(String value) {
            addCriterion("ContactInfo not like", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoIn(List<String> values) {
            addCriterion("ContactInfo in", values, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoNotIn(List<String> values) {
            addCriterion("ContactInfo not in", values, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoBetween(String value1, String value2) {
            addCriterion("ContactInfo between", value1, value2, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoNotBetween(String value1, String value2) {
            addCriterion("ContactInfo not between", value1, value2, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andTaskcompletionIsNull() {
            addCriterion("TaskCompletion is null");
            return (Criteria) this;
        }

        public Criteria andTaskcompletionIsNotNull() {
            addCriterion("TaskCompletion is not null");
            return (Criteria) this;
        }

        public Criteria andTaskcompletionEqualTo(String value) {
            addCriterion("TaskCompletion =", value, "taskcompletion");
            return (Criteria) this;
        }

        public Criteria andTaskcompletionNotEqualTo(String value) {
            addCriterion("TaskCompletion <>", value, "taskcompletion");
            return (Criteria) this;
        }

        public Criteria andTaskcompletionGreaterThan(String value) {
            addCriterion("TaskCompletion >", value, "taskcompletion");
            return (Criteria) this;
        }

        public Criteria andTaskcompletionGreaterThanOrEqualTo(String value) {
            addCriterion("TaskCompletion >=", value, "taskcompletion");
            return (Criteria) this;
        }

        public Criteria andTaskcompletionLessThan(String value) {
            addCriterion("TaskCompletion <", value, "taskcompletion");
            return (Criteria) this;
        }

        public Criteria andTaskcompletionLessThanOrEqualTo(String value) {
            addCriterion("TaskCompletion <=", value, "taskcompletion");
            return (Criteria) this;
        }

        public Criteria andTaskcompletionLike(String value) {
            addCriterion("TaskCompletion like", value, "taskcompletion");
            return (Criteria) this;
        }

        public Criteria andTaskcompletionNotLike(String value) {
            addCriterion("TaskCompletion not like", value, "taskcompletion");
            return (Criteria) this;
        }

        public Criteria andTaskcompletionIn(List<String> values) {
            addCriterion("TaskCompletion in", values, "taskcompletion");
            return (Criteria) this;
        }

        public Criteria andTaskcompletionNotIn(List<String> values) {
            addCriterion("TaskCompletion not in", values, "taskcompletion");
            return (Criteria) this;
        }

        public Criteria andTaskcompletionBetween(String value1, String value2) {
            addCriterion("TaskCompletion between", value1, value2, "taskcompletion");
            return (Criteria) this;
        }

        public Criteria andTaskcompletionNotBetween(String value1, String value2) {
            addCriterion("TaskCompletion not between", value1, value2, "taskcompletion");
            return (Criteria) this;
        }

        public Criteria andEventinfoIsNull() {
            addCriterion("EventInfo is null");
            return (Criteria) this;
        }

        public Criteria andEventinfoIsNotNull() {
            addCriterion("EventInfo is not null");
            return (Criteria) this;
        }

        public Criteria andEventinfoEqualTo(String value) {
            addCriterion("EventInfo =", value, "eventinfo");
            return (Criteria) this;
        }

        public Criteria andEventinfoNotEqualTo(String value) {
            addCriterion("EventInfo <>", value, "eventinfo");
            return (Criteria) this;
        }

        public Criteria andEventinfoGreaterThan(String value) {
            addCriterion("EventInfo >", value, "eventinfo");
            return (Criteria) this;
        }

        public Criteria andEventinfoGreaterThanOrEqualTo(String value) {
            addCriterion("EventInfo >=", value, "eventinfo");
            return (Criteria) this;
        }

        public Criteria andEventinfoLessThan(String value) {
            addCriterion("EventInfo <", value, "eventinfo");
            return (Criteria) this;
        }

        public Criteria andEventinfoLessThanOrEqualTo(String value) {
            addCriterion("EventInfo <=", value, "eventinfo");
            return (Criteria) this;
        }

        public Criteria andEventinfoLike(String value) {
            addCriterion("EventInfo like", value, "eventinfo");
            return (Criteria) this;
        }

        public Criteria andEventinfoNotLike(String value) {
            addCriterion("EventInfo not like", value, "eventinfo");
            return (Criteria) this;
        }

        public Criteria andEventinfoIn(List<String> values) {
            addCriterion("EventInfo in", values, "eventinfo");
            return (Criteria) this;
        }

        public Criteria andEventinfoNotIn(List<String> values) {
            addCriterion("EventInfo not in", values, "eventinfo");
            return (Criteria) this;
        }

        public Criteria andEventinfoBetween(String value1, String value2) {
            addCriterion("EventInfo between", value1, value2, "eventinfo");
            return (Criteria) this;
        }

        public Criteria andEventinfoNotBetween(String value1, String value2) {
            addCriterion("EventInfo not between", value1, value2, "eventinfo");
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

        public Criteria andDepartmentidEqualTo(String value) {
            addCriterion("DepartmentID =", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotEqualTo(String value) {
            addCriterion("DepartmentID <>", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThan(String value) {
            addCriterion("DepartmentID >", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThanOrEqualTo(String value) {
            addCriterion("DepartmentID >=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThan(String value) {
            addCriterion("DepartmentID <", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThanOrEqualTo(String value) {
            addCriterion("DepartmentID <=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLike(String value) {
            addCriterion("DepartmentID like", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotLike(String value) {
            addCriterion("DepartmentID not like", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIn(List<String> values) {
            addCriterion("DepartmentID in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotIn(List<String> values) {
            addCriterion("DepartmentID not in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidBetween(String value1, String value2) {
            addCriterion("DepartmentID between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotBetween(String value1, String value2) {
            addCriterion("DepartmentID not between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andShifteventsIsNull() {
            addCriterion("ShiftEvents is null");
            return (Criteria) this;
        }

        public Criteria andShifteventsIsNotNull() {
            addCriterion("ShiftEvents is not null");
            return (Criteria) this;
        }

        public Criteria andShifteventsEqualTo(String value) {
            addCriterion("ShiftEvents =", value, "shiftevents");
            return (Criteria) this;
        }

        public Criteria andShifteventsNotEqualTo(String value) {
            addCriterion("ShiftEvents <>", value, "shiftevents");
            return (Criteria) this;
        }

        public Criteria andShifteventsGreaterThan(String value) {
            addCriterion("ShiftEvents >", value, "shiftevents");
            return (Criteria) this;
        }

        public Criteria andShifteventsGreaterThanOrEqualTo(String value) {
            addCriterion("ShiftEvents >=", value, "shiftevents");
            return (Criteria) this;
        }

        public Criteria andShifteventsLessThan(String value) {
            addCriterion("ShiftEvents <", value, "shiftevents");
            return (Criteria) this;
        }

        public Criteria andShifteventsLessThanOrEqualTo(String value) {
            addCriterion("ShiftEvents <=", value, "shiftevents");
            return (Criteria) this;
        }

        public Criteria andShifteventsLike(String value) {
            addCriterion("ShiftEvents like", value, "shiftevents");
            return (Criteria) this;
        }

        public Criteria andShifteventsNotLike(String value) {
            addCriterion("ShiftEvents not like", value, "shiftevents");
            return (Criteria) this;
        }

        public Criteria andShifteventsIn(List<String> values) {
            addCriterion("ShiftEvents in", values, "shiftevents");
            return (Criteria) this;
        }

        public Criteria andShifteventsNotIn(List<String> values) {
            addCriterion("ShiftEvents not in", values, "shiftevents");
            return (Criteria) this;
        }

        public Criteria andShifteventsBetween(String value1, String value2) {
            addCriterion("ShiftEvents between", value1, value2, "shiftevents");
            return (Criteria) this;
        }

        public Criteria andShifteventsNotBetween(String value1, String value2) {
            addCriterion("ShiftEvents not between", value1, value2, "shiftevents");
            return (Criteria) this;
        }

        public Criteria andIssignIsNull() {
            addCriterion("IsSign is null");
            return (Criteria) this;
        }

        public Criteria andIssignIsNotNull() {
            addCriterion("IsSign is not null");
            return (Criteria) this;
        }

        public Criteria andIssignEqualTo(Integer value) {
            addCriterion("IsSign =", value, "issign");
            return (Criteria) this;
        }

        public Criteria andIssignNotEqualTo(Integer value) {
            addCriterion("IsSign <>", value, "issign");
            return (Criteria) this;
        }

        public Criteria andIssignGreaterThan(Integer value) {
            addCriterion("IsSign >", value, "issign");
            return (Criteria) this;
        }

        public Criteria andIssignGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsSign >=", value, "issign");
            return (Criteria) this;
        }

        public Criteria andIssignLessThan(Integer value) {
            addCriterion("IsSign <", value, "issign");
            return (Criteria) this;
        }

        public Criteria andIssignLessThanOrEqualTo(Integer value) {
            addCriterion("IsSign <=", value, "issign");
            return (Criteria) this;
        }

        public Criteria andIssignIn(List<Integer> values) {
            addCriterion("IsSign in", values, "issign");
            return (Criteria) this;
        }

        public Criteria andIssignNotIn(List<Integer> values) {
            addCriterion("IsSign not in", values, "issign");
            return (Criteria) this;
        }

        public Criteria andIssignBetween(Integer value1, Integer value2) {
            addCriterion("IsSign between", value1, value2, "issign");
            return (Criteria) this;
        }

        public Criteria andIssignNotBetween(Integer value1, Integer value2) {
            addCriterion("IsSign not between", value1, value2, "issign");
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