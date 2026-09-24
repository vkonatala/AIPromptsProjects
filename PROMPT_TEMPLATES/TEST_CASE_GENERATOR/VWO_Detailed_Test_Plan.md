# VWO Application – Detailed Test Plan

## 1. Document Information

| Item | Details |
|---|---|
| Product | VWO – Visual Website Optimizer / Digital Experience Optimization Platform |
| Application URL | https://app.vwo.com/ |
| Test Plan Type | Functional, Integration, UI, API, Security, Performance, Compatibility, Accessibility, Data, Reliability and Regression |
| Primary Users | Product Managers, Growth/CRO teams, Marketers, QA, Developers, Analysts, Administrators |
| Prepared By | QA / Product Management perspective |
| Scope Basis | Publicly documented VWO capabilities and the VWO application entry point |
| Assumption | Full authenticated feature coverage requires a valid VWO test account, suitable permissions, sample website, traffic/test data and required integrations |

---

# 2. Executive Summary

VWO is an experimentation and digital-experience optimization platform. Its documented capabilities include web A/B testing, Split URL testing, multivariate testing, visual/code editors, audience targeting, metrics and reporting, heatmaps, session recordings, integrations, feature experimentation, personalization and rollout capabilities.

The central business workflow is:

**Create experiment → Configure pages/audience → Create variations → Configure metrics → Preview/QA → Launch → Collect traffic → Analyze results → Decide → Roll out/iterate**

The test strategy therefore needs to validate not only individual screens and controls but also the correctness of the complete experimentation lifecycle.

A critical quality objective is:

> A user must be able to configure and execute an experiment without the platform incorrectly exposing visitors to the wrong experience, recording incorrect metrics, corrupting experiment data, or producing misleading reports.

---

# 3. Product Understanding

## 3.1 Major Product Areas

The test plan covers the following product areas:

1. Authentication and account access
2. User and account management
3. Dashboard
4. Campaign/experiment management
5. A/B testing
6. Split URL testing
7. Multivariate testing
8. Visual/WYSIWYG Editor
9. Code Editor
10. Widgets
11. Audience targeting and segmentation
12. Traffic allocation
13. Goals and metrics
14. Campaign scheduling and triggers
15. Preview and debugging
16. Campaign launch, pause and stop
17. Campaign monitoring
18. Reports and SmartStats
19. Funnels
20. Heatmaps
21. Session recordings
22. Insights/behavior analytics
23. Hypotheses and experimentation workflow
24. Integrations
25. Feature experimentation and feature flags
26. Rollouts
27. AI-assisted capabilities
28. Notifications
29. Audit/history/versioning
30. Data export
31. Permissions and role-based access
32. Security and privacy
33. Performance
34. Accessibility
35. Cross-browser/device compatibility
36. Reliability and recovery

---

# 4. Business Objectives

The test strategy should protect the following business outcomes:

### BO-01 – Accurate experimentation

Experiments must expose users to the intended experience and maintain correct control/variation assignment.

### BO-02 – Accurate measurement

Conversions, revenue, events and other configured metrics must be captured accurately.

### BO-03 – Trustworthy reporting

Reports must reflect the underlying experiment data without incorrect aggregation, duplication or loss.

### BO-04 – Safe deployment

Experiment configuration or rollout must not unexpectedly break the customer's website or application.

### BO-05 – Audience correctness

Only visitors satisfying targeting rules should enter the relevant campaign.

### BO-06 – Platform reliability

Running, pausing, editing or stopping campaigns must not corrupt campaign state or visitor experience.

### BO-07 – Secure customer data

Customer, visitor, experiment and integration data must be protected against unauthorized access.

---

# 5. Test Objectives

1. Verify all supported user journeys.
2. Validate positive and negative scenarios.
3. Validate experiment configuration rules.
4. Validate visitor targeting and segmentation.
5. Verify variation assignment and traffic allocation.
6. Verify metric/event collection.
7. Verify reporting calculations and filters.
8. Verify experiment state transitions.
9. Verify integrations and external data exchange.
10. Verify role-based access.
11. Verify data persistence.
12. Verify browser/device compatibility.
13. Verify accessibility.
14. Verify performance under realistic traffic and campaign volumes.
15. Verify security controls.
16. Verify recovery after failures.
17. Verify backward compatibility during releases.
18. Validate end-to-end business workflows.

---

# 6. Scope

## 6.1 In Scope

### Core Platform

- Login/logout
- Account access
- Dashboard
- Campaign creation
- Campaign editing
- Campaign duplication
- Campaign deletion/archive
- Campaign status
- Campaign search/filter
- Campaign navigation

### Experimentation

- A/B testing
- Split URL testing
- Multivariate testing
- Variation management
- Audience selection
- Traffic allocation
- Campaign scheduling
- Trigger configuration
- Metrics
- Goals
- Reports

### Editors

- Visual Editor
- Code Editor
- HTML/CSS/JavaScript changes
- Element selection
- Text/image changes
- CSS modifications
- Dynamic/interactive elements
- Undo/redo
- Save/versioning
- Preview

### Analytics

- Reports
- Funnels
- Heatmaps
- Session recordings
- Visitor segmentation
- Behavioral insights
- Conversion data

### Platform Integrations

- Analytics integrations
- CDP/data-source integrations
- CMS/e-commerce integrations
- Productivity/notification integrations
- Data export

### Advanced Capabilities

- Feature flags
- Feature experimentation
- Rollouts
- AI-assisted campaign creation/editor functionality
- Guardrail/critical metrics where available
- Environment-specific testing

---

# 7. Out of Scope

Unless specifically included in the release:

- Third-party application internal functionality
- Customer website defects unrelated to VWO
- External analytics platform defects
- Customer's own infrastructure
- Production experiments using real customer traffic
- Unsupported browsers/devices
- Third-party service outages beyond VWO's control

---

# 8. Test Environment

## 8.1 Application Environment

Recommended environments:

- Development
- QA
- Staging
- Production-like environment

## 8.2 Browser Matrix

Minimum:

- Chrome – latest supported version
- Microsoft Edge – latest supported version
- Firefox – latest supported version
- Safari – latest supported version

Additional:

- Chrome latest-1
- Edge latest-1
- Firefox latest-1
- Safari latest-1

## 8.3 Operating Systems

- Windows 10/11
- macOS
- Android
- iOS

## 8.4 Devices

Desktop:

- 1366×768
- 1440×900
- 1920×1080

Mobile:

- iPhone
- Android phone

Tablet:

- iPad
- Android tablet

---

# 9. Test Data Strategy

Create controlled test data covering:

### Users

- Super Admin
- Account Admin
- Standard User
- Read-only User
- Restricted User

### Campaigns

- Draft campaign
- Running campaign
- Paused campaign
- Completed campaign
- Archived campaign
- Campaign with no traffic
- Campaign with high traffic

### Variations

- Control only
- One variation
- Multiple variations
- Large number of variations
- Variation containing HTML
- Variation containing CSS
- Variation containing JavaScript
- Variation with invalid code

### Audiences

- All visitors
- Desktop
- Mobile
- New visitors
- Returning visitors
- Geographic audience
- Browser-based audience
- Custom event audience
- URL-based audience
- Compound audience conditions

### Metrics

- Primary metric
- Secondary metric
- Custom event
- Revenue metric
- Funnel conversion
- Multiple metrics
- Invalid metric configuration

---

# 10. Functional Test Scenarios

## 10.1 Authentication

| ID | Scenario | Expected Result | Priority |
|---|---|---|---|
| AUTH-001 | Login with valid credentials | User successfully logs in | P0 |
| AUTH-002 | Invalid username/password | Appropriate error displayed | P0 |
| AUTH-003 | Empty username | Validation displayed | P1 |
| AUTH-004 | Empty password | Validation displayed | P1 |
| AUTH-005 | Logout | Session terminated | P0 |
| AUTH-006 | Browser refresh after login | User remains authenticated as expected | P1 |
| AUTH-007 | Session timeout | User is redirected/re-authenticated | P0 |
| AUTH-008 | Direct URL access without authentication | Unauthorized access prevented | P0 |
| AUTH-009 | Multiple sessions | Behavior follows security policy | P1 |

---

# 11. Dashboard Test Scenarios

1. Dashboard loads successfully.
2. Correct account information is displayed.
3. Campaign counts are accurate.
4. Campaign status is accurate.
5. Running campaigns are displayed correctly.
6. Completed campaigns are displayed correctly.
7. Search works.
8. Filters work.
9. Sorting works.
10. Pagination works.
11. Empty-state behavior is correct.
12. Dashboard handles large campaign counts.
13. User can navigate to campaign details.
14. Refresh does not corrupt state.
15. Unauthorized campaigns are not displayed.

---

# 12. Campaign Creation

## Test Scenarios

1. Create A/B campaign.
2. Create Split URL campaign.
3. Create Multivariate campaign.
4. Enter valid campaign name.
5. Enter duplicate campaign name.
6. Enter maximum-length campaign name.
7. Enter special characters.
8. Save campaign as draft.
9. Cancel campaign creation.
10. Navigate away before saving.
11. Restore saved draft.
12. Duplicate existing campaign.
13. Delete campaign.
14. Archive campaign.
15. Search campaign.
16. Filter campaign.
17. Verify campaign ownership.
18. Verify permissions.

---

# 13. A/B Testing

## Core Scenarios

1. Create control and one variation.
2. Create multiple variations.
3. Configure traffic allocation.
4. Allocate 50/50 traffic.
5. Allocate 90/10 traffic.
6. Verify allocations total correctly.
7. Attempt invalid allocation.
8. Change allocation before launch.
9. Verify control receives expected traffic.
10. Verify variation receives expected traffic.
11. Verify visitor remains consistently assigned where applicable.
12. Refresh visitor page.
13. Navigate across multiple pages.
14. Verify experience consistency.
15. Start campaign.
16. Pause campaign.
17. Resume campaign.
18. Stop campaign.
19. Verify campaign status.
20. Verify reports after traffic arrives.

---

# 14. Split URL Testing

Test:

1. Valid source URL.
2. Valid destination URL.
3. Redirect behavior.
4. HTTPS URL.
5. HTTP-to-HTTPS behavior where supported.
6. Query parameters.
7. URL fragments.
8. Dynamic URLs.
9. Multiple destination URLs.
10. Traffic allocation.
11. Incorrect URL.
12. Unreachable destination.
13. Redirect loops.
14. Cross-domain behavior where supported.
15. Analytics attribution.
16. Conversion tracking.

---

# 15. Multivariate Testing

Test:

1. Multiple page elements.
2. Multiple variations per element.
3. Combination generation.
4. Traffic distribution.
5. Combination reporting.
6. Invalid configuration.
7. Very large number of combinations.
8. Editing combinations.
9. Removing an element.
10. Removing a variation.
11. Preview each combination.
12. Verify conversion metrics per combination.

---

# 16. Visual Editor

## Functional Scenarios

1. Open Visual Editor.
2. Load target website.
3. Select page element.
4. Change text.
5. Change image.
6. Change CSS.
7. Add element.
8. Remove element.
9. Move element.
10. Resize element.
11. Add link.
12. Add button.
13. Modify button text.
14. Modify font.
15. Modify background.
16. Modify borders.
17. Add custom CSS.
18. Undo change.
19. Redo change.
20. Save changes.
21. Cancel changes.
22. Preview variation.
23. Test responsive view.
24. Test hidden elements.
25. Test dynamically loaded elements.
26. Test SPA pages.
27. Test shadow DOM where supported.
28. Test page with iframe.
29. Test page with strict CSP.
30. Test page with heavy JavaScript.

---

# 17. Code Editor

Test:

1. Add valid JavaScript.
2. Add invalid JavaScript.
3. Add CSS.
4. Add HTML.
5. Add external script where supported.
6. Add campaign-level code.
7. Add variation-level code.
8. Test execution order.
9. Test JavaScript exceptions.
10. Test syntax validation.
11. Test malicious script input.
12. Save code.
13. Undo code changes.
14. Preview code.
15. Launch campaign with code.
16. Stop campaign and verify code no longer executes.

---

# 18. Widgets

Test supported widgets such as:

- Popups
- Banners
- Forms
- Countdown timers
- Trigger-based widgets
- Custom widgets

Scenarios:

1. Create widget.
2. Edit widget.
3. Configure trigger.
4. Configure audience.
5. Configure display frequency.
6. Preview widget.
7. Validate mobile display.
8. Validate desktop display.
9. Close widget.
10. Reopen according to configured behavior.
11. Validate conversion event.
12. Test conflicting widgets.
13. Test multiple widgets.
14. Test widget removal.

---

# 19. Audience Targeting

Test combinations based on:

- Device
- Browser
- Operating system
- Geography
- Visitor type
- Traffic source
- URL
- Behavioral conditions
- Custom events
- External data

Test:

1. Single condition.
2. AND condition.
3. OR condition.
4. Nested conditions.
5. Exclusion condition.
6. Empty audience.
7. Very large audience.
8. Invalid condition.
9. Saved segment.
10. Reusable segment.
11. Audience modification after campaign creation.
12. Audience modification while campaign is running.
13. Verify only eligible visitors receive campaign.

---

# 20. Traffic Allocation

Test:

1. 50/50 allocation.
2. 80/20 allocation.
3. 90/10 allocation.
4. 100% control.
5. 100% variation.
6. Multiple variations.
7. Decimal allocation if supported.
8. Invalid total.
9. Save allocation.
10. Modify allocation.
11. Verify actual traffic distribution.
12. Validate behavior under low traffic.
13. Validate behavior under high traffic.

---

# 21. Metrics and Goals

Test:

1. Create primary goal.
2. Create secondary goal.
3. Select existing metric.
4. Create custom metric.
5. Track click.
6. Track page visit.
7. Track form submission.
8. Track custom event.
9. Track revenue.
10. Track funnel conversion.
11. Multiple goals.
12. Duplicate goals.
13. Invalid goal.
14. Delete goal.
15. Change goal before launch.
16. Verify event data.
17. Verify conversion count.
18. Verify conversion rate.
19. Verify revenue calculations.

---

# 22. Campaign Lifecycle

Campaign states should be validated as a state machine:

**Draft → Ready → Running → Paused → Running → Completed/Stopped → Archived**

Test:

1. Valid state transition.
2. Invalid state transition.
3. Pause running campaign.
4. Resume paused campaign.
5. Stop campaign.
6. Restart where supported.
7. Edit campaign while running.
8. Attempt restricted edit.
9. Verify state persistence after refresh.
10. Verify state after logout/login.
11. Verify state after backend/API failure.

---

# 23. Preview and Debugging

Test:

1. Preview control.
2. Preview variation.
3. Preview different devices.
4. Preview different screen sizes.
5. Preview targeted audience.
6. Preview JavaScript variation.
7. Preview CSS variation.
8. Preview widgets.
9. Share preview where supported.
10. Verify preview does not affect production metrics.
11. Verify preview does not accidentally become visible to normal visitors.

---

# 24. Reporting

Reports are business-critical and require deep validation.

Test:

1. Report loads.
2. Correct campaign is displayed.
3. Correct control is displayed.
4. Correct variation is displayed.
5. Primary metric is correct.
6. Secondary metrics are correct.
7. Conversion count is correct.
8. Conversion rate is correct.
9. Revenue is correct.
10. Date filtering works.
11. Segment filtering works.
12. Device filtering works.
13. Browser filtering works.
14. Geographic filtering works.
15. Custom dimension filtering works.
16. Report refresh works.
17. Empty-data state works.
18. Large-data report works.
19. Export works.
20. Shared report works.
21. Report permissions are enforced.
22. Report remains consistent after campaign changes.

---

# 25. Statistical Validation

Where statistical reporting is exposed, validate:

1. Control metrics.
2. Variation metrics.
3. Difference between control and variation.
4. Probability calculations.
5. Better-than-control classification.
6. Worse-than-control classification.
7. Practical-equivalence classification where applicable.
8. Sample size.
9. Confidence/statistical indicators shown by the product.
10. Outlier handling.
11. Multiple-testing/peeking safeguards.
12. Segment-level statistics.
13. Metric-level statistics.
14. Consistency between dashboard and detailed report.

Statistical calculations should be independently verified using controlled datasets and expected mathematical results.

---

# 26. Funnel Testing

Test:

1. Create funnel.
2. Add funnel steps.
3. Reorder steps.
4. Remove step.
5. View conversion between steps.
6. Identify drop-off.
7. Filter funnel by audience.
8. Filter by device.
9. Filter by variation.
10. Validate funnel against raw events.
11. Validate missing-event behavior.
12. Validate duplicate events.
13. Validate out-of-order events.

---

# 27. Heatmaps

Test:

1. Heatmap loads.
2. Click map.
3. Scroll map.
4. Element interaction.
5. Device filtering.
6. Browser filtering.
7. Audience filtering.
8. Variation filtering where supported.
9. Dynamic elements.
10. SPA navigation.
11. Large page.
12. Responsive page.
13. No-data state.
14. Privacy-sensitive content masking.

---

# 28. Session Recordings

Test:

1. Recording captured.
2. Recording playback.
3. Pause/play.
4. Seek.
5. Filter recordings.
6. Search/filter by user behavior.
7. Filter by device.
8. Filter by browser.
9. Filter by campaign.
10. Filter by conversion.
11. Rage-click behavior.
12. Drop-off behavior.
13. Sensitive-data masking.
14. Recording deletion/retention rules.
15. Large recording volume.
16. Playback failure handling.

---

# 29. Integrations

For each integration:

1. Connect integration.
2. Authenticate.
3. Validate OAuth/token behavior.
4. Validate permissions.
5. Import data.
6. Export data.
7. Trigger event.
8. Verify event received.
9. Verify mapping.
10. Verify duplicate handling.
11. Test invalid credentials.
12. Test expired credentials.
13. Disconnect integration.
14. Reconnect integration.
15. Test integration outage.
16. Validate retry behavior.
17. Validate error messages.
18. Validate audit logs.

---

# 30. Feature Experimentation

Where enabled:

1. Create feature.
2. Create feature variable.
3. Configure default value.
4. Configure flag.
5. Enable flag.
6. Disable flag.
7. Gradual rollout.
8. Instant rollback.
9. Change variable at runtime.
10. Validate SDK behavior.
11. Validate API behavior.
12. Validate environment-specific behavior.
13. Validate user targeting.
14. Validate experiment assignment.
15. Validate persistence.
16. Validate rollback during active traffic.

---

# 31. AI-Assisted Features

For AI-powered campaign creation/editor capabilities:

1. Enter valid natural-language request.
2. Generate variation.
3. Verify generated variation matches request.
4. Modify generated variation.
5. Regenerate variation.
6. Generate multiple alternatives.
7. Test ambiguous prompt.
8. Test unsupported prompt.
9. Test malicious prompt.
10. Test prompt containing HTML/JS.
11. Verify AI does not unintentionally modify unrelated elements.
12. Verify user approval is required before launch.
13. Validate generated code.
14. Validate error handling.
15. Validate latency.
16. Validate usage limits where applicable.
17. Verify sensitive information is not exposed.

AI output should be treated as untrusted until reviewed and validated.

---

# 32. User Management and RBAC

Roles to test:

- Administrator
- Manager
- Editor
- Analyst
- Viewer
- Restricted/custom roles

For each role verify:

1. Login.
2. Dashboard access.
3. Campaign creation.
4. Campaign editing.
5. Campaign launch.
6. Campaign pause.
7. Campaign deletion.
8. Report access.
9. Account settings.
10. User management.
11. Integration management.
12. Export access.
13. Audit/history access.

Negative testing is mandatory: users must not access functionality outside their permissions through UI or direct API calls.

---

# 33. Security Testing

## Authentication

- Brute-force protection
- Password policy
- Session management
- Session timeout
- Concurrent sessions
- Logout invalidation
- MFA where available

## Authorization

- Horizontal privilege escalation
- Vertical privilege escalation
- Direct URL access
- Direct API access
- Object-level authorization

## Input Security

Test for:

- XSS
- Stored XSS
- Reflected XSS
- HTML injection
- JavaScript injection
- SQL injection where applicable
- Command injection where applicable
- Template injection
- Malicious URLs
- File upload vulnerabilities where applicable

## Data Security

- HTTPS
- Sensitive data masking
- Token protection
- API credential protection
- PII handling
- Session recording privacy
- Data export authorization
- Audit logs

---

# 34. API Testing

If APIs are exposed:

### Validate

- Authentication
- Authorization
- HTTP methods
- Status codes
- Headers
- Request schema
- Response schema
- Required fields
- Optional fields
- Boundary values
- Invalid payloads
- Duplicate requests
- Idempotency
- Pagination
- Sorting
- Filtering
- Rate limiting
- Error responses
- Timeout behavior
- Retry behavior
- API version compatibility

### Example API Assertions

```text
200 – Successful request
201 – Resource created
400 – Invalid request
401 – Unauthenticated
403 – Unauthorized
404 – Resource not found
409 – Conflict
429 – Rate limit
500 – Server error
```

---

# 35. Database/Data Validation

Where database access is available:

1. Campaign created in UI exists in backend.
2. Campaign update persists.
3. Variation configuration persists.
4. Audience configuration persists.
5. Metrics persist.
6. Events are not duplicated.
7. Deleted entities follow retention rules.
8. Campaign state is consistent.
9. User permissions are consistent.
10. Report aggregates match source events.

---

# 36. Performance Testing

## Application

Measure:

- Page load time
- Time to interactive
- API response time
- Dashboard load
- Campaign creation
- Report generation
- Editor loading
- Preview loading
- Export generation

## Experiment Runtime

Measure:

- SmartCode impact
- Variation rendering time
- Assignment latency
- Event transmission latency
- Analytics processing delay

## Load Tests

Simulate:

- 100 concurrent users
- 500 concurrent users
- 1,000 concurrent users
- Large campaign volume
- Large event volume
- High report traffic
- Concurrent campaign launches

---

# 37. Reliability Testing

Test:

1. Network interruption.
2. API timeout.
3. Backend service unavailable.
4. Browser refresh during save.
5. Browser close during save.
6. Duplicate submission.
7. Partial integration failure.
8. Analytics service failure.
9. Event ingestion failure.
10. Recovery after outage.
11. Retry behavior.
12. Data consistency after recovery.

---

# 38. Compatibility Testing

Validate:

### Browsers

- Chrome
- Edge
- Firefox
- Safari

### Devices

- Desktop
- Laptop
- Tablet
- Mobile

### Responsive

- 320px
- 375px
- 390px
- 414px
- 768px
- 1024px
- 1366px
- 1920px

---

# 39. Accessibility Testing

Target WCAG 2.1/2.2 AA where applicable.

Test:

1. Keyboard-only navigation.
2. Tab order.
3. Focus visibility.
4. Screen reader support.
5. Form labels.
6. Error messages.
7. Color contrast.
8. Accessible buttons.
9. Accessible links.
10. Modal focus management.
11. Escape key behavior.
12. ARIA attributes.
13. Zoom up to 200%.
14. Responsive reflow.
15. Dynamic content announcements.

Tools:

- axe DevTools
- Lighthouse
- NVDA
- VoiceOver
- Keyboard-only testing

---

# 40. UX Testing

Evaluate:

1. Navigation clarity.
2. Terminology consistency.
3. Error-message clarity.
4. Empty states.
5. Loading states.
6. Confirmation messages.
7. Destructive-action warnings.
8. Unsaved-change warnings.
9. Discoverability of features.
10. Consistency between screens.
11. Responsive usability.
12. Report readability.
13. Campaign setup usability.
14. Editor usability.

---

# 41. Negative Testing

Important negative cases:

- Invalid URL
- Invalid JavaScript
- Invalid CSS
- Invalid HTML
- Invalid audience condition
- Invalid metric
- Invalid traffic allocation
- Duplicate campaign
- Missing required field
- Expired session
- Unauthorized campaign
- Unauthorized API request
- Broken integration
- Network interruption
- Backend timeout
- Large input
- Special characters
- Unicode
- Emoji
- HTML injection
- JavaScript injection
- Extremely long campaign name
- Extremely large number of variations

---

# 42. Boundary Value Testing

Examples:

| Field | Boundary Tests |
|---|---|
| Campaign name | Empty, 1 char, max length, max+1 |
| Traffic | 0%, 1%, 99%, 100%, invalid >100% |
| Variations | 0, 1, maximum, maximum+1 |
| Audience rules | 0, 1, many |
| Metrics | 0, 1, maximum |
| URL | Empty, valid, invalid, extremely long |
| Text | Empty, normal, max, Unicode, HTML |
| API payload | Empty, minimum, maximum, malformed |

---

# 43. End-to-End Business Scenarios

## E2E-001 – Basic A/B Experiment

1. Login.
2. Create A/B campaign.
3. Enter target URL.
4. Open Visual Editor.
5. Create variation.
6. Configure audience.
7. Configure traffic allocation.
8. Configure primary metric.
9. Preview.
10. Save.
11. Launch.
12. Generate test traffic.
13. Verify visitor assignment.
14. Verify conversion event.
15. Open report.
16. Verify metrics.
17. Share/export report.
18. Stop campaign.
19. Verify final state.

## E2E-002 – Targeted Experiment

1. Create campaign.
2. Configure mobile audience.
3. Configure geographic audience.
4. Create variation.
5. Launch.
6. Test eligible visitor.
7. Test non-eligible visitor.
8. Validate assignment.
9. Validate metrics.
10. Validate report segmentation.

## E2E-003 – Experiment to Rollout

1. Create experiment.
2. Run experiment.
3. Collect traffic.
4. Analyze report.
5. Identify selected variation based on configured business decision.
6. Configure rollout.
7. Publish.
8. Verify production experience.
9. Verify rollback capability.

## E2E-004 – Integration

1. Configure analytics integration.
2. Authenticate.
3. Create campaign.
4. Launch.
5. Generate conversion.
6. Verify VWO event.
7. Verify external analytics event.
8. Compare data.
9. Disconnect integration.
10. Validate failure behavior.

---

# 44. Regression Test Suite

## P0 Regression

Run for every major release:

- Login
- Dashboard
- Campaign creation
- A/B test
- Variation creation
- Audience
- Traffic allocation
- Metrics
- Preview
- Launch
- Pause
- Report
- Export
- Permissions
- Logout

## P1 Regression

- Split URL
- Multivariate
- Code editor
- Widgets
- Funnels
- Heatmaps
- Recordings
- Integrations
- Scheduling
- Advanced targeting

## P2 Regression

- Rare edge cases
- Advanced customization
- Uncommon integrations
- Legacy functionality

---

# 45. Automation Strategy

Given a QA automation environment, automate:

### UI

- Login
- Campaign CRUD
- Campaign search/filter
- Campaign configuration
- Audience configuration
- Metrics configuration
- Campaign lifecycle
- Report navigation
- User permissions

Recommended:

- Playwright
- Selenium

### API

Automate:

- Campaign APIs
- User APIs
- Audience APIs
- Metrics APIs
- Reporting APIs
- Integration APIs

Recommended:

- REST Assured
- Postman/Newman

### Visual Testing

Use:

- Playwright screenshots
- Percy/Applitools where approved
- Baseline comparison

### Accessibility

- axe-core
- Lighthouse

### Performance

- k6
- JMeter

### CI/CD

Recommended pipeline:

```text
Commit
  ↓
Build
  ↓
Unit Tests
  ↓
API Tests
  ↓
UI Smoke
  ↓
Accessibility
  ↓
Regression
  ↓
Visual Tests
  ↓
Performance Checks
  ↓
Allure Report
  ↓
Release Decision
```

---

# 46. Automation Framework Recommendation

A scalable framework can use:

```text
VWO-Automation
│
├── src/test/java
│   ├── tests
│   │   ├── auth
│   │   ├── campaigns
│   │   ├── editor
│   │   ├── audience
│   │   ├── metrics
│   │   ├── reports
│   │   ├── integrations
│   │   └── permissions
│   │
│   ├── pages
│   ├── components
│   ├── api
│   ├── models
│   ├── utilities
│   └── assertions
│
├── src/test/resources
│   ├── features
│   ├── testdata
│   └── config
│
└── reports
    └── allure
```

Recommended stack:

- Java 17+
- Selenium 4 / Playwright
- Cucumber
- REST Assured
- Maven
- Git
- CI/CD
- Allure
- Docker where appropriate

---

# 47. Test Prioritization

Use risk-based prioritization.

## P0 – Business Critical

- Authentication
- Authorization
- Campaign creation
- Traffic allocation
- Visitor assignment
- Event tracking
- Conversion tracking
- Report accuracy
- Campaign launch/stop
- Data integrity
- Security

## P1 – High

- Visual Editor
- Code Editor
- Audience targeting
- Metrics
- Integrations
- Funnels
- Session recordings
- Heatmaps
- Export

## P2 – Medium

- UI preferences
- Advanced filters
- Rare configurations
- Non-critical notifications

## P3 – Low

- Cosmetic issues
- Minor usability improvements
- Low-use configuration options

---

# 48. Entry Criteria

Testing can begin when:

1. Build is deployed.
2. Environment is available.
3. Requirements are approved.
4. Test account is available.
5. Required permissions are configured.
6. Test website is available.
7. Test data is available.
8. Third-party integrations are available.
9. Known blockers are resolved.

---

# 49. Exit Criteria

Testing can be completed when:

1. All P0 scenarios pass.
2. Agreed P1 coverage is complete.
3. No open critical defects exist.
4. No open blocker defects exist.
5. Security testing is complete.
6. Regression is complete.
7. Performance criteria are met.
8. Accessibility criteria are met.
9. Data integrity is validated.
10. Business-critical E2E workflows pass.
11. Stakeholders approve release readiness.

---

# 50. Defect Severity

| Severity | Definition |
|---|---|
| Sev-1 | Complete platform/business-critical failure, security breach, incorrect experiment assignment or major data corruption |
| Sev-2 | Major feature unavailable or materially incorrect business/reporting behavior |
| Sev-3 | Feature partially affected with workaround |
| Sev-4 | Cosmetic/minor usability issue |

---

# 51. Key Quality Risks

## Risk 1 – Incorrect visitor assignment

Impact: Experiment conclusions become unreliable.

Mitigation:

- Validate allocation
- Validate targeting
- Validate persistence
- Validate cross-page behavior
- Validate cross-device behavior where applicable

## Risk 2 – Incorrect conversion tracking

Impact: Business decisions based on incorrect data.

Mitigation:

- Compare raw events against VWO metrics.
- Validate duplicate events.
- Validate missing events.
- Validate event ordering.

## Risk 3 – Report calculation errors

Impact: Incorrect experimentation decisions.

Mitigation:

- Use controlled datasets.
- Independently calculate expected results.
- Validate dashboard vs detailed report.

## Risk 4 – Editor breaks customer website

Impact: Revenue/customer experience impact.

Mitigation:

- Preview testing.
- Cross-browser testing.
- JavaScript error monitoring.
- CSP testing.
- Responsive testing.
- Rollback testing.

## Risk 5 – Integration failure

Impact: Missing or inconsistent data.

Mitigation:

- Contract/API tests.
- Retry testing.
- Failure injection.
- Data reconciliation.

---

# 52. Product Manager / Business Analyst Acceptance Criteria

A release should satisfy these business questions:

### Experiment Creation

- Can a business user create an experiment without unnecessary engineering intervention?
- Can the intended audience be defined accurately?
- Can variations be created safely?

### Experiment Execution

- Do visitors receive the intended experience?
- Is traffic distributed according to configuration?
- Are visitors consistently assigned where required?

### Measurement

- Are conversions recorded correctly?
- Are revenue and custom metrics correct?
- Can stakeholders trust the report?

### Decision Making

- Can stakeholders understand the experiment results?
- Can reports be filtered and shared?
- Can the result be exported?

### Deployment

- Can a validated change be rolled out safely?
- Can a rollout be reversed?
- Is the production experience protected from invalid configurations?

---

# 53. Traceability Matrix

| Requirement | Functional | API | UI | Security | Performance | E2E |
|---|---:|---:|---:|---:|---:|---:|
| Authentication | ✓ | ✓ | ✓ | ✓ | ✓ | ✓ |
| Campaign Creation | ✓ | ✓ | ✓ | ✓ | ✓ | ✓ |
| A/B Testing | ✓ | ✓ | ✓ | ✓ | ✓ | ✓ |
| Audience | ✓ | ✓ | ✓ | ✓ | ✓ | ✓ |
| Metrics | ✓ | ✓ | ✓ | ✓ | ✓ | ✓ |
| Reporting | ✓ | ✓ | ✓ | ✓ | ✓ | ✓ |
| Integrations | ✓ | ✓ | ✓ | ✓ | ✓ | ✓ |
| Feature Flags | ✓ | ✓ | ✓ | ✓ | ✓ | ✓ |
| Rollouts | ✓ | ✓ | ✓ | ✓ | ✓ | ✓ |
| User Management | ✓ | ✓ | ✓ | ✓ | ✓ | ✓ |

---

# 54. Recommended Test Execution Phases

## Phase 1 – Smoke

Duration: 1–2 hours

- Login
- Dashboard
- Campaign creation
- Basic variation
- Launch
- Report

## Phase 2 – Functional

Duration: 1–3 days depending on release scope

- Core feature testing
- Negative testing
- Boundary testing
- Campaign lifecycle

## Phase 3 – Integration

- Analytics
- CDP
- CMS
- Notifications
- APIs

## Phase 4 – Regression

- Full critical-path suite
- Cross-browser
- Cross-device

## Phase 5 – Non-functional

- Performance
- Security
- Accessibility
- Reliability

## Phase 6 – Business Acceptance

- End-to-end experimentation
- Reporting validation
- Rollout validation
- Stakeholder sign-off

---

# 55. Critical Test Scenarios – Top 20

1. User cannot access another customer's account.
2. User cannot access unauthorized campaigns.
3. A/B traffic allocation is accurate.
4. Targeting rules are correctly enforced.
5. Visitor assignment is consistent.
6. Control and variation content are correct.
7. Conversion events are captured once.
8. Revenue is calculated correctly.
9. Reports match source events.
10. Campaign pause immediately follows configured behavior.
11. Campaign stop prevents unintended exposure.
12. Visual Editor changes do not corrupt the target page.
13. Invalid JavaScript does not bring down the customer page.
14. Preview does not pollute production experiment statistics.
15. Split URL redirects work correctly.
16. Multivariate combinations are generated correctly.
17. Integrations exchange correct data.
18. Session recordings protect sensitive data.
19. Feature flag rollback works correctly.
20. End-to-end experiment produces trustworthy data from visitor exposure through final report.

---

# 56. Final QA Recommendation

The most important testing principle for VWO is to treat the platform as a **data and experimentation system**, not merely as a web UI.

The highest-risk chain is:

```text
Campaign Configuration
        ↓
Audience Evaluation
        ↓
Visitor Assignment
        ↓
Variation Delivery
        ↓
User Interaction
        ↓
Event Collection
        ↓
Metric Calculation
        ↓
Statistical Processing
        ↓
Report
        ↓
Business Decision
        ↓
Rollout
```

A defect anywhere in this chain can produce a technically functioning application while still producing an incorrect business outcome.

Therefore, the highest automation and validation priority should be:

**Experiment configuration → targeting → assignment → tracking → metrics → reporting → rollout**

This should be supported by UI automation, API/contract testing, data reconciliation, security testing, performance testing, accessibility testing and controlled end-to-end experiments.
