package cn.ccf.pojo;

import java.util.ArrayList;
import java.util.List;

public class CaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CaseExample() {
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

        public Criteria andKeywordsIsNull() {
            addCriterion("Keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("Keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("Keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("Keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("Keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("Keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("Keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("Keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("Keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("Keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("Keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("Keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("Keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("Keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andEventscaleIsNull() {
            addCriterion("Eventscale is null");
            return (Criteria) this;
        }

        public Criteria andEventscaleIsNotNull() {
            addCriterion("Eventscale is not null");
            return (Criteria) this;
        }

        public Criteria andEventscaleEqualTo(String value) {
            addCriterion("Eventscale =", value, "eventscale");
            return (Criteria) this;
        }

        public Criteria andEventscaleNotEqualTo(String value) {
            addCriterion("Eventscale <>", value, "eventscale");
            return (Criteria) this;
        }

        public Criteria andEventscaleGreaterThan(String value) {
            addCriterion("Eventscale >", value, "eventscale");
            return (Criteria) this;
        }

        public Criteria andEventscaleGreaterThanOrEqualTo(String value) {
            addCriterion("Eventscale >=", value, "eventscale");
            return (Criteria) this;
        }

        public Criteria andEventscaleLessThan(String value) {
            addCriterion("Eventscale <", value, "eventscale");
            return (Criteria) this;
        }

        public Criteria andEventscaleLessThanOrEqualTo(String value) {
            addCriterion("Eventscale <=", value, "eventscale");
            return (Criteria) this;
        }

        public Criteria andEventscaleLike(String value) {
            addCriterion("Eventscale like", value, "eventscale");
            return (Criteria) this;
        }

        public Criteria andEventscaleNotLike(String value) {
            addCriterion("Eventscale not like", value, "eventscale");
            return (Criteria) this;
        }

        public Criteria andEventscaleIn(List<String> values) {
            addCriterion("Eventscale in", values, "eventscale");
            return (Criteria) this;
        }

        public Criteria andEventscaleNotIn(List<String> values) {
            addCriterion("Eventscale not in", values, "eventscale");
            return (Criteria) this;
        }

        public Criteria andEventscaleBetween(String value1, String value2) {
            addCriterion("Eventscale between", value1, value2, "eventscale");
            return (Criteria) this;
        }

        public Criteria andEventscaleNotBetween(String value1, String value2) {
            addCriterion("Eventscale not between", value1, value2, "eventscale");
            return (Criteria) this;
        }

        public Criteria andEventlevelIsNull() {
            addCriterion("Eventlevel is null");
            return (Criteria) this;
        }

        public Criteria andEventlevelIsNotNull() {
            addCriterion("Eventlevel is not null");
            return (Criteria) this;
        }

        public Criteria andEventlevelEqualTo(String value) {
            addCriterion("Eventlevel =", value, "eventlevel");
            return (Criteria) this;
        }

        public Criteria andEventlevelNotEqualTo(String value) {
            addCriterion("Eventlevel <>", value, "eventlevel");
            return (Criteria) this;
        }

        public Criteria andEventlevelGreaterThan(String value) {
            addCriterion("Eventlevel >", value, "eventlevel");
            return (Criteria) this;
        }

        public Criteria andEventlevelGreaterThanOrEqualTo(String value) {
            addCriterion("Eventlevel >=", value, "eventlevel");
            return (Criteria) this;
        }

        public Criteria andEventlevelLessThan(String value) {
            addCriterion("Eventlevel <", value, "eventlevel");
            return (Criteria) this;
        }

        public Criteria andEventlevelLessThanOrEqualTo(String value) {
            addCriterion("Eventlevel <=", value, "eventlevel");
            return (Criteria) this;
        }

        public Criteria andEventlevelLike(String value) {
            addCriterion("Eventlevel like", value, "eventlevel");
            return (Criteria) this;
        }

        public Criteria andEventlevelNotLike(String value) {
            addCriterion("Eventlevel not like", value, "eventlevel");
            return (Criteria) this;
        }

        public Criteria andEventlevelIn(List<String> values) {
            addCriterion("Eventlevel in", values, "eventlevel");
            return (Criteria) this;
        }

        public Criteria andEventlevelNotIn(List<String> values) {
            addCriterion("Eventlevel not in", values, "eventlevel");
            return (Criteria) this;
        }

        public Criteria andEventlevelBetween(String value1, String value2) {
            addCriterion("Eventlevel between", value1, value2, "eventlevel");
            return (Criteria) this;
        }

        public Criteria andEventlevelNotBetween(String value1, String value2) {
            addCriterion("Eventlevel not between", value1, value2, "eventlevel");
            return (Criteria) this;
        }

        public Criteria andEventtimeIsNull() {
            addCriterion("Eventtime is null");
            return (Criteria) this;
        }

        public Criteria andEventtimeIsNotNull() {
            addCriterion("Eventtime is not null");
            return (Criteria) this;
        }

        public Criteria andEventtimeEqualTo(String value) {
            addCriterion("Eventtime =", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeNotEqualTo(String value) {
            addCriterion("Eventtime <>", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeGreaterThan(String value) {
            addCriterion("Eventtime >", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeGreaterThanOrEqualTo(String value) {
            addCriterion("Eventtime >=", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeLessThan(String value) {
            addCriterion("Eventtime <", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeLessThanOrEqualTo(String value) {
            addCriterion("Eventtime <=", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeLike(String value) {
            addCriterion("Eventtime like", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeNotLike(String value) {
            addCriterion("Eventtime not like", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeIn(List<String> values) {
            addCriterion("Eventtime in", values, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeNotIn(List<String> values) {
            addCriterion("Eventtime not in", values, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeBetween(String value1, String value2) {
            addCriterion("Eventtime between", value1, value2, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeNotBetween(String value1, String value2) {
            addCriterion("Eventtime not between", value1, value2, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventaddressIsNull() {
            addCriterion("Eventaddress is null");
            return (Criteria) this;
        }

        public Criteria andEventaddressIsNotNull() {
            addCriterion("Eventaddress is not null");
            return (Criteria) this;
        }

        public Criteria andEventaddressEqualTo(String value) {
            addCriterion("Eventaddress =", value, "eventaddress");
            return (Criteria) this;
        }

        public Criteria andEventaddressNotEqualTo(String value) {
            addCriterion("Eventaddress <>", value, "eventaddress");
            return (Criteria) this;
        }

        public Criteria andEventaddressGreaterThan(String value) {
            addCriterion("Eventaddress >", value, "eventaddress");
            return (Criteria) this;
        }

        public Criteria andEventaddressGreaterThanOrEqualTo(String value) {
            addCriterion("Eventaddress >=", value, "eventaddress");
            return (Criteria) this;
        }

        public Criteria andEventaddressLessThan(String value) {
            addCriterion("Eventaddress <", value, "eventaddress");
            return (Criteria) this;
        }

        public Criteria andEventaddressLessThanOrEqualTo(String value) {
            addCriterion("Eventaddress <=", value, "eventaddress");
            return (Criteria) this;
        }

        public Criteria andEventaddressLike(String value) {
            addCriterion("Eventaddress like", value, "eventaddress");
            return (Criteria) this;
        }

        public Criteria andEventaddressNotLike(String value) {
            addCriterion("Eventaddress not like", value, "eventaddress");
            return (Criteria) this;
        }

        public Criteria andEventaddressIn(List<String> values) {
            addCriterion("Eventaddress in", values, "eventaddress");
            return (Criteria) this;
        }

        public Criteria andEventaddressNotIn(List<String> values) {
            addCriterion("Eventaddress not in", values, "eventaddress");
            return (Criteria) this;
        }

        public Criteria andEventaddressBetween(String value1, String value2) {
            addCriterion("Eventaddress between", value1, value2, "eventaddress");
            return (Criteria) this;
        }

        public Criteria andEventaddressNotBetween(String value1, String value2) {
            addCriterion("Eventaddress not between", value1, value2, "eventaddress");
            return (Criteria) this;
        }

        public Criteria andEventdescribeIsNull() {
            addCriterion("EventDescribe is null");
            return (Criteria) this;
        }

        public Criteria andEventdescribeIsNotNull() {
            addCriterion("EventDescribe is not null");
            return (Criteria) this;
        }

        public Criteria andEventdescribeEqualTo(String value) {
            addCriterion("EventDescribe =", value, "eventdescribe");
            return (Criteria) this;
        }

        public Criteria andEventdescribeNotEqualTo(String value) {
            addCriterion("EventDescribe <>", value, "eventdescribe");
            return (Criteria) this;
        }

        public Criteria andEventdescribeGreaterThan(String value) {
            addCriterion("EventDescribe >", value, "eventdescribe");
            return (Criteria) this;
        }

        public Criteria andEventdescribeGreaterThanOrEqualTo(String value) {
            addCriterion("EventDescribe >=", value, "eventdescribe");
            return (Criteria) this;
        }

        public Criteria andEventdescribeLessThan(String value) {
            addCriterion("EventDescribe <", value, "eventdescribe");
            return (Criteria) this;
        }

        public Criteria andEventdescribeLessThanOrEqualTo(String value) {
            addCriterion("EventDescribe <=", value, "eventdescribe");
            return (Criteria) this;
        }

        public Criteria andEventdescribeLike(String value) {
            addCriterion("EventDescribe like", value, "eventdescribe");
            return (Criteria) this;
        }

        public Criteria andEventdescribeNotLike(String value) {
            addCriterion("EventDescribe not like", value, "eventdescribe");
            return (Criteria) this;
        }

        public Criteria andEventdescribeIn(List<String> values) {
            addCriterion("EventDescribe in", values, "eventdescribe");
            return (Criteria) this;
        }

        public Criteria andEventdescribeNotIn(List<String> values) {
            addCriterion("EventDescribe not in", values, "eventdescribe");
            return (Criteria) this;
        }

        public Criteria andEventdescribeBetween(String value1, String value2) {
            addCriterion("EventDescribe between", value1, value2, "eventdescribe");
            return (Criteria) this;
        }

        public Criteria andEventdescribeNotBetween(String value1, String value2) {
            addCriterion("EventDescribe not between", value1, value2, "eventdescribe");
            return (Criteria) this;
        }

        public Criteria andEventsolutionIsNull() {
            addCriterion("EventSolution is null");
            return (Criteria) this;
        }

        public Criteria andEventsolutionIsNotNull() {
            addCriterion("EventSolution is not null");
            return (Criteria) this;
        }

        public Criteria andEventsolutionEqualTo(String value) {
            addCriterion("EventSolution =", value, "eventsolution");
            return (Criteria) this;
        }

        public Criteria andEventsolutionNotEqualTo(String value) {
            addCriterion("EventSolution <>", value, "eventsolution");
            return (Criteria) this;
        }

        public Criteria andEventsolutionGreaterThan(String value) {
            addCriterion("EventSolution >", value, "eventsolution");
            return (Criteria) this;
        }

        public Criteria andEventsolutionGreaterThanOrEqualTo(String value) {
            addCriterion("EventSolution >=", value, "eventsolution");
            return (Criteria) this;
        }

        public Criteria andEventsolutionLessThan(String value) {
            addCriterion("EventSolution <", value, "eventsolution");
            return (Criteria) this;
        }

        public Criteria andEventsolutionLessThanOrEqualTo(String value) {
            addCriterion("EventSolution <=", value, "eventsolution");
            return (Criteria) this;
        }

        public Criteria andEventsolutionLike(String value) {
            addCriterion("EventSolution like", value, "eventsolution");
            return (Criteria) this;
        }

        public Criteria andEventsolutionNotLike(String value) {
            addCriterion("EventSolution not like", value, "eventsolution");
            return (Criteria) this;
        }

        public Criteria andEventsolutionIn(List<String> values) {
            addCriterion("EventSolution in", values, "eventsolution");
            return (Criteria) this;
        }

        public Criteria andEventsolutionNotIn(List<String> values) {
            addCriterion("EventSolution not in", values, "eventsolution");
            return (Criteria) this;
        }

        public Criteria andEventsolutionBetween(String value1, String value2) {
            addCriterion("EventSolution between", value1, value2, "eventsolution");
            return (Criteria) this;
        }

        public Criteria andEventsolutionNotBetween(String value1, String value2) {
            addCriterion("EventSolution not between", value1, value2, "eventsolution");
            return (Criteria) this;
        }

        public Criteria andEventresultIsNull() {
            addCriterion("EventResult is null");
            return (Criteria) this;
        }

        public Criteria andEventresultIsNotNull() {
            addCriterion("EventResult is not null");
            return (Criteria) this;
        }

        public Criteria andEventresultEqualTo(String value) {
            addCriterion("EventResult =", value, "eventresult");
            return (Criteria) this;
        }

        public Criteria andEventresultNotEqualTo(String value) {
            addCriterion("EventResult <>", value, "eventresult");
            return (Criteria) this;
        }

        public Criteria andEventresultGreaterThan(String value) {
            addCriterion("EventResult >", value, "eventresult");
            return (Criteria) this;
        }

        public Criteria andEventresultGreaterThanOrEqualTo(String value) {
            addCriterion("EventResult >=", value, "eventresult");
            return (Criteria) this;
        }

        public Criteria andEventresultLessThan(String value) {
            addCriterion("EventResult <", value, "eventresult");
            return (Criteria) this;
        }

        public Criteria andEventresultLessThanOrEqualTo(String value) {
            addCriterion("EventResult <=", value, "eventresult");
            return (Criteria) this;
        }

        public Criteria andEventresultLike(String value) {
            addCriterion("EventResult like", value, "eventresult");
            return (Criteria) this;
        }

        public Criteria andEventresultNotLike(String value) {
            addCriterion("EventResult not like", value, "eventresult");
            return (Criteria) this;
        }

        public Criteria andEventresultIn(List<String> values) {
            addCriterion("EventResult in", values, "eventresult");
            return (Criteria) this;
        }

        public Criteria andEventresultNotIn(List<String> values) {
            addCriterion("EventResult not in", values, "eventresult");
            return (Criteria) this;
        }

        public Criteria andEventresultBetween(String value1, String value2) {
            addCriterion("EventResult between", value1, value2, "eventresult");
            return (Criteria) this;
        }

        public Criteria andEventresultNotBetween(String value1, String value2) {
            addCriterion("EventResult not between", value1, value2, "eventresult");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("FileName is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("FileName is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("FileName =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("FileName <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("FileName >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("FileName >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("FileName <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("FileName <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("FileName like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("FileName not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("FileName in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("FileName not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("FileName between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("FileName not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNull() {
            addCriterion("FilePath is null");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNotNull() {
            addCriterion("FilePath is not null");
            return (Criteria) this;
        }

        public Criteria andFilepathEqualTo(String value) {
            addCriterion("FilePath =", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotEqualTo(String value) {
            addCriterion("FilePath <>", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThan(String value) {
            addCriterion("FilePath >", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThanOrEqualTo(String value) {
            addCriterion("FilePath >=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThan(String value) {
            addCriterion("FilePath <", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThanOrEqualTo(String value) {
            addCriterion("FilePath <=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLike(String value) {
            addCriterion("FilePath like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotLike(String value) {
            addCriterion("FilePath not like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathIn(List<String> values) {
            addCriterion("FilePath in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotIn(List<String> values) {
            addCriterion("FilePath not in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathBetween(String value1, String value2) {
            addCriterion("FilePath between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotBetween(String value1, String value2) {
            addCriterion("FilePath not between", value1, value2, "filepath");
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