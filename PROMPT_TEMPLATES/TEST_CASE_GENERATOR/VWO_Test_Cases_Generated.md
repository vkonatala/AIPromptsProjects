# VWO Test Cases – Generated from VWO_Detailed_Test_Plan

**Role:** Senior QA Engineer  
**Source:** VWO_Detailed_Test_Plan.md  
**Format:** | Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |

---

## TC-10-AUTH: Authentication

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-AUTH-001 | Login with valid credentials | User has valid VWO account credentials | 1. Navigate to https://app.vwo.com/<br>2. Enter valid email<br>3. Enter valid password<br>4. Click Login | User is logged in and redirected to the dashboard | P0 |
| TC-AUTH-002 | Login with invalid username/password | User has invalid credentials | 1. Navigate to https://app.vwo.com/<br>2. Enter invalid email or password<br>3. Click Login | Appropriate error message displayed, login not successful | P0 |
| TC-AUTH-003 | Login with empty username | Login page loaded | 1. Navigate to login page<br>2. Leave email field empty<br>3. Click Login | Validation error displayed for email field | P1 |
| TC-AUTH-004 | Login with empty password | Login page loaded | 1. Navigate to login page<br>2. Enter valid email<br>3. Leave password field empty<br>4. Click Login | Validation error displayed for password field | P1 |
| TC-AUTH-005 | Logout | User is logged in | 1. Click user menu/profile<br>2. Click Logout | Session is terminated, user redirected to login page | P0 |
| TC-AUTH-006 | Browser refresh after login | User is logged in | 1. Navigate to any VWO page<br>2. Refresh the browser | User remains authenticated and stays on the same page | P1 |
| TC-AUTH-007 | Session timeout | User is logged in | 1. Remain idle for the configured session timeout duration<br>2. Attempt to interact with the application | User is redirected to login or re-authentication page | P0 |
| TC-AUTH-008 | Direct URL access without authentication | No active session | 1. Open incognito/private browser<br>2. Navigate directly to a protected VWO URL (e.g., /dashboard/campaigns) | Unauthorized access prevented; user redirected to login page | P0 |
| TC-AUTH-009 | Multiple concurrent sessions | User is logged in on one session | 1. Log in on session A<br>2. Log in on session B (same account)<br>3. Perform actions on both sessions | Behavior follows the VWO security policy (not specified beyond this); both sessions or policy-defined behavior | P1 |

---

## TC-11-DASH: Dashboard

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-DASH-001 | Dashboard loads successfully | User is logged in | 1. Log in with valid credentials<br>2. Navigate to dashboard | Dashboard loads without errors and displays overview content | P0 |
| TC-DASH-002 | Correct account information displayed | User is logged in | 1. Log in to dashboard<br>2. Observe account header/profile area | Account name, email, and organization details are displayed correctly | P0 |
| TC-DASH-003 | Campaign counts are accurate | Account has existing campaigns | 1. Log in to dashboard<br>2. Observe campaign count values | Campaign counts (running, draft, completed, etc.) match the actual state in the account | P0 |
| TC-DASH-004 | Campaign status is accurate | Account has campaigns in various states | 1. Log in to dashboard<br>2. Observe campaign status labels | Campaign status labels (Draft, Running, Paused, Completed, Stopped) are accurate | P1 |
| TC-DASH-005 | Running campaigns displayed correctly | Account has running campaigns | 1. Log in to dashboard<br>2. View the running campaigns section | Running campaigns are listed with correct names, statuses, and metrics snippets | P1 |
| TC-DASH-006 | Completed campaigns displayed correctly | Account has completed campaigns | 1. Log in to dashboard<br>2. View the completed campaigns section | Completed campaigns are listed with correct completion data | P1 |
| TC-DASH-007 | Dashboard search works | Dashboard is loaded with campaign list | 1. Enter a campaign name in the search box<br>2. Press Enter | Campaign list is filtered to show only matching campaigns | P1 |
| TC-DASH-008 | Dashboard filters work | Dashboard is loaded | 1. Apply a status filter (e.g., Running)<br>2. Observe results | Campaign list is filtered by the selected status; filter is clearly indicated | P1 |
| TC-DASH-009 | Dashboard sorting works | Dashboard loaded with campaign list | 1. Click a sortable column header (e.g., Created Date)<br>2. Click again to reverse | Campaign list is sorted by the selected column and direction | P1 |
| TC-DASH-010 | Empty-state behavior | Account with zero campaigns | 1. Log in to dashboard for an account with no campaigns | Appropriate empty-state message or call-to-action is displayed | P1 |
| TC-DASH-011 | Dashboard handles large campaign counts | Account with many campaigns | 1. Log in to a dashboard with 100+ campaigns | Dashboard loads and paginates without degradation or rendering issues | P2 |
| TC-DASH-012 | Navigate to campaign details | Dashboard loaded | 1. Click on a campaign card/row | User is navigated to the campaign details/configuration page | P0 |

---

## TC-12-CREATE: Campaign Creation

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-CREATE-001 | Create A/B campaign | User is on campaign creation page | 1. Click Create Campaign<br>2. Select A/B Test type<br>3. Enter campaign name<br>4. Enter target URL<br>5. Click Next/Continue | A/B campaign is created in Draft status | P0 |
| TC-CREATE-002 | Create Split URL campaign | User is on campaign creation page | 1. Click Create Campaign<br>2. Select Split URL Test type<br>3. Enter source and destination URLs<br>4. Save | Split URL campaign is created in Draft status | P1 |
| TC-CREATE-003 | Create Multivariate campaign | User is on campaign creation page | 1. Click Create Campaign<br>2. Select Multivariate Test type<br>3. Configure elements/variations<br>4. Save | Multivariate campaign is created in Draft status | P1 |
| TC-CREATE-004 | Enter valid campaign name | On campaign creation form | 1. Enter a valid (unique, reasonable-length) campaign name<br>2. Proceed | Campaign name is accepted and saved | P0 |
| TC-CREATE-005 | Enter duplicate campaign name | At least one campaign already exists with name "Summer Sale 2024" | 1. Create a new campaign named "Summer Sale 2024" | System warns of duplicate name; user can confirm or change; not specified whether creation is blocked | P1 |
| TC-CREATE-006 | Enter maximum-length campaign name | On campaign creation form | 1. Enter a campaign name using the maximum supported character count<br>2. Save | Campaign is created successfully with the full name displayed | P2 |
| TC-CREATE-007 | Enter special characters in campaign name | On campaign creation form | 1. Enter a campaign name with special characters (e.g., `<>&"'`)<br>2. Save | Special characters are handled safely (escaped/sanitized); no rendering or injection issues | P1 |
| TC-CREATE-008 | Save campaign as draft | On campaign creation form with valid name and URL | 1. Fill in campaign details<br>2. Click Save as Draft | Campaign is saved in Draft status and appears in the Draft list | P0 |
| TC-CREATE-009 | Cancel campaign creation | On campaign creation form | 1. Fill in partial details<br>2. Click Cancel | Campaign creation is discarded; user returns to dashboard (not confirmed if a warning prompts first) | P1 |
| TC-CREATE-010 | Navigate away before saving | On campaign creation form with unsaved changes | 1. Fill in details but do not save<br>2. Navigate away or close tab | Unsaved-change warning displayed; navigation may be allowed or blocked (not specified) | P1 |
| TC-CREATE-011 | Restore saved draft | A saved draft campaign exists | 1. Navigate to Draft campaigns list<br>2. Click the saved draft | Draft campaign is restored and editable | P0 |
| TC-CREATE-012 | Duplicate existing campaign | An existing campaign exists | 1. Click Duplicate on an existing campaign<br>2. Confirm | A new copy of the campaign is created (likely in Draft status) | P1 |
| TC-CREATE-013 | Delete campaign | An existing campaign (in Draft/Stopped state) | 1. Select Delete on an existing campaign<br>2. Confirm deletion | Campaign is removed from the list | P1 |
| TC-CREATE-014 | Archive campaign | A completed/stopped campaign exists | 1. Click Archive on the campaign<br>2. Confirm | Campaign is archived and moves out of active lists | P1 |
| TC-CREATE-015 | Search campaigns | On campaigns list page | 1. Enter search text in the campaigns search box | Campaign list is filtered to matching results | P1 |
| TC-CREATE-016 | Filter campaigns | On campaigns list page | 1. Apply a filter (e.g., status, type)<br>2. Observe results | Campaign list is filtered accordingly | P1 |
| TC-CREATE-017 | Verify campaign ownership | User belongs to a multi-user account | 1. View campaigns list<br>2. Observe ownership column/details | Campaign owner is displayed correctly | P2 |
| TC-CREATE-018 | Verify permissions on campaign | User with non-admin role | 1. View campaign actions available | Only permitted actions are available; restricted actions are hidden or disabled | P1 |

---

## TC-13-AB: A/B Testing

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-AB-001 | Create control and one variation | On A/B campaign variation editor | 1. Add one variation to the control | Control and variation are both listed | P0 |
| TC-AB-002 | Create multiple variations | On A/B campaign variation editor | 1. Add 2+ variations | All variations are listed | P1 |
| TC-AB-003 | Configure 50/50 traffic allocation | A/B campaign with control + 1 variation | 1. Open traffic allocation settings<br>2. Set 50/50 split | Allocation displays 50/50; saves successfully | P0 |
| TC-AB-004 | Configure 90/10 traffic allocation | A/B campaign with control + 1 variation | 1. Open traffic allocation settings<br>2. Set 90/10 split | Allocation displays 90/10; saves successfully | P0 |
| TC-AB-005 | Verify allocations total 100% | A/B campaign with multiple variations | 1. Open traffic allocation settings<br>2. Adjust allocations<br>3. Observe total | Total always sums to 100% (or system enforces this) | P0 |
| TC-AB-006 | Attempt invalid allocation | A/B campaign with multiple variations | 1. Open traffic allocation settings<br>2. Enter values summing to >100% | System rejects or clamps; error/validation displayed | P0 |
| TC-AB-007 | Change allocation before launch | A/B campaign in Draft | 1. Change traffic allocation<br>2. Save | New allocation is persisted | P0 |
| TC-AB-008 | Verify control receives expected traffic | Launched A/B campaign with 50/50 split | 1. Generate test traffic<br>2. Inspect assignment logs | Control receives ~50% of eligible visitors | P0 |
| TC-AB-009 | Verify variation receives expected traffic | Launched A/B campaign with 50/50 split | 1. Generate test traffic<br>2. Inspect assignment logs | Variation receives ~50% of eligible visitors | P0 |
| TC-AB-010 | Verify visitor remains consistently assigned | Launched A/B campaign | 1. Visit the site as the same visitor across multiple sessions<br>2. Observe assigned variation | Visitor is consistently assigned to the same variation across sessions/pages | P0 |
| TC-AB-011 | Refresh visitor page | Launched A/B campaign, visitor already assigned | 1. Refresh the page in the browser | Same variation is served on refresh | P0 |
| TC-AB-012 | Navigate across multiple pages | Launched A/B campaign | 1. Navigate between pages on the target site | Same variation is served consistently across all pages | P0 |
| TC-AB-013 | Verify experience consistency | Launched A/B campaign | 1. Browse multiple pages as a visitor | The variation's changes are consistently applied | P0 |
| TC-AB-014 | Start campaign | A/B campaign in Ready/Draft | 1. Click Start/Launch | Campaign transitions to Running status | P0 |
| TC-AB-015 | Pause campaign | A/B campaign in Running | 1. Click Pause | Campaign transitions to Paused status; visitors stop receiving the experience | P0 |
| TC-AB-016 | Resume campaign | A/B campaign in Paused | 1. Click Resume/Start | Campaign transitions back to Running | P0 |
| TC-AB-017 | Stop campaign | A/B campaign in Running or Paused | 1. Click Stop | Campaign transitions to Stopped status; visitors no longer receive the experience | P0 |
| TC-AB-018 | Verify campaign status after action | A/B campaign in any state | 1. Perform a lifecycle action (Start/Pause/Stop)<br>2. Observe status badge | Status badge reflects the new state | P1 |
| TC-AB-019 | Verify reports after traffic | Running A/B campaign with traffic | 1. Generate traffic<br>2. Navigate to Reports tab | Report displays visitor counts, conversion counts, and conversion rates for control and variation | P0 |

---

## TC-14-SPLIT: Split URL Testing

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-SPLIT-001 | Valid source URL | On Split URL campaign configuration | 1. Enter a valid source URL<br>2. Proceed | Source URL is accepted | P0 |
| TC-SPLIT-002 | Valid destination URL | On Split URL campaign configuration | 1. Enter a valid destination URL<br>2. Proceed | Destination URL is accepted | P0 |
| TC-SPLIT-003 | Redirect behavior | Split URL campaign launched | 1. Generate traffic to source URL | Visitor is redirected to the destination URL per the allocation rules | P0 |
| TC-SPLIT-004 | HTTPS URL | On Split URL configuration | 1. Enter HTTPS source and destination URLs | HTTPS URLs are accepted and handled correctly | P0 |
| TC-SPLIT-005 | Query parameters in URL | Split URL campaign configured | 1. Navigate to source URL with query parameters | Query parameters are preserved/passed according to config | P1 |
| TC-SPLIT-006 | URL fragments | Split URL campaign configured | 1. Navigate to source URL with a fragment | Fragment behavior is consistent with config (not specified further) | P2 |
| TC-SPLIT-007 | Dynamic URLs | Split URL campaign configured | 1. Navigate to a dynamic URL pattern | Wildcard/dynamic URL matching works as configured | P1 |
| TC-SPLIT-008 | Multiple destination URLs | Split URL campaign configuration | 1. Configure multiple destinations | Each destination receives traffic per allocation | P1 |
| TC-SPLIT-009 | Incorrect URL format | Split URL configuration | 1. Enter a malformed URL<br>2. Attempt to save | Validation error displayed; save rejected | P0 |
| TC-SPLIT-010 | Unreachable destination | Split URL campaign launched | 1. Generate traffic to a destination that returns an error | Fallback behavior follows product design (not specified); error handled gracefully | P1 |

---

## TC-15-MVT: Multivariate Testing

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-MVT-001 | Multiple page elements | On MVT campaign variation editor | 1. Select multiple elements to vary | All selected elements are included in the MVT | P1 |
| TC-MVT-002 | Multiple variations per element | On MVT campaign variation editor | 1. Add multiple variations for each selected element | Variations are configured and listed per element | P1 |
| TC-MVT-003 | Combination generation | MVT with elements and variations defined | 1. Open the combination preview | All valid combinatorial combinations are auto-generated | P0 |
| TC-MVT-004 | Traffic distribution across combinations | Launched MVT campaign | 1. Generate traffic<br>2. Inspect assignment | Traffic is distributed across combinations as configured | P0 |
| TC-MVT-005 | Report per combination | MVT campaign with traffic | 1. Navigate to Reports | Each combination shows its own conversion data | P1 |
| TC-MVT-006 | Invalid MVT configuration | On MVT editor | 1. Attempt an invalid combination (e.g., conflicting selections)<br>2. Save | System validates and rejects invalid configuration | P0 |
| TC-MVT-007 | Large number of combinations | MVT with many elements/variations | 1. Create a large number of combinations | System handles gracefully (may cap or warn; not specified) | P2 |

---

## TC-17-VE: Visual/WYSIWYG Editor

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-VE-001 | Open Visual Editor | Campaign with a target URL is configured | 1. Click Open Visual Editor | Visual Editor loads and the target website is displayed | P0 |
| TC-VE-002 | Load target website | Visual Editor opened | 1. Observe the loaded page | The target website renders fully in the editor | P0 |
| TC-VE-003 | Select page element | Visual Editor with loaded page | 1. Click on a page element | Element is selected and highlighted | P1 |
| TC-VE-004 | Change text | Element selected in editor | 1. Edit text content<br>2. Apply | Text is updated; change persists on save | P1 |
| TC-VE-005 | Change image | Image element selected | 1. Replace the image<br>2. Apply | New image is displayed; change persists | P1 |
| TC-VE-006 | Change CSS | Element selected | 1. Modify CSS property (e.g., color)<br>2. Apply | CSS change is applied and visible | P1 |
| TC-VE-007 | Add element | Visual Editor | 1. Add a new HTML element | New element appears on the page | P1 |
| TC-VE-008 | Remove element | Element selected | 1. Remove the element | Element is hidden/removed from the variation | P1 |
| TC-VE-009 | Move element | Element selected | 1. Drag the element to a new position | Element position changes; persists on save | P1 |
| TC-VE-010 | Resize element | Element selected | 1. Resize the element dimensions | Element resizes; persists on save | P1 |
| TC-VE-011 | Add link | Text/element selected | 1. Add a hyperlink to the element | Link is applied and clickable | P1 |
| TC-VE-012 | Add button | Visual Editor | 1. Insert a button element | Button appears and functions | P1 |
| TC-VE-013 | Modify button text | Button element selected | 1. Edit button label<br>2. Apply | Button text updates | P2 |
| TC-VE-014 | Modify font | Element selected | 1. Change font family/size<br>2. Apply | Font changes are applied | P1 |
| TC-VE-015 | Modify background | Element/section selected | 1. Change background color/image<br>2. Apply | Background changes are applied | P1 |
| TC-VE-016 | Modify borders | Element selected | 1. Change border style/width/color<br>2. Apply | Border changes are applied | P2 |
| TC-VE-017 | Add custom CSS | Visual Editor | 1. Open custom CSS panel<br>2. Enter CSS rules<br>3. Apply | Custom CSS is applied to the variation | P1 |
| TC-VE-018 | Undo change | Visual Editor with a change applied | 1. Make a change<br>2. Click Undo | Change is reverted | P0 |
| TC-VE-019 | Redo change | After undoing | 1. Click Redo | Change is re-applied | P0 |
| TC-VE-020 | Save changes | Visual Editor with edits | 1. Click Save | Changes are persisted to the variation | P0 |
| TC-VE-021 | Cancel changes | Visual Editor with unsaved edits | 1. Click Cancel | Changes are discarded; not specified if a warning is shown | P1 |
| TC-VE-022 | Preview variation | Visual Editor with saved edits | 1. Click Preview | A preview of the variation is shown | P0 |
| TC-VE-023 | Test responsive view | Visual Editor open | 1. Select device toggle/responsive mode | Variation is shown at the selected viewport | P1 |

---

## TC-17-CODE: Code Editor

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-CODE-001 | Add valid JavaScript | Code Editor open | 1. Enter valid JavaScript<br>2. Save | Code is saved without errors | P0 |
| TC-CODE-002 | Add invalid JavaScript | Code Editor open | 1. Enter syntactically invalid JavaScript<br>2. Save | Syntax validation flags the error; not specified if save is blocked | P1 |
| TC-CODE-003 | Add CSS via code editor | Code Editor open | 1. Enter CSS rules<br>2. Save | CSS is saved and applied to the campaign | P1 |
| TC-CODE-004 | Add HTML via code editor | Code Editor open | 1. Enter HTML markup<br>2. Save | HTML is saved and applied | P1 |
| TC-CODE-005 | Add campaign-level code | Code Editor for a campaign | 1. Switch to campaign-level code view<br>2. Enter code<br>3. Save | Code applies at campaign level | P1 |
| TC-CODE-006 | Add variation-level code | Code Editor for a specific variation | 1. Switch to variation-level code view<br>2. Enter code<br>3. Save | Code applies to that variation only | P1 |
| TC-CODE-007 | Verify execution order | Campaign with both campaign-level and variation-level code | 1. Define both code scopes<br>2. Preview/Launch | Code executes in the defined order (not specified which runs first) | P1 |
| TC-CODE-008 | JavaScript exception handling | Campaign with JavaScript containing a runtime error | 1. Launch campaign<br>2. Generate traffic | Error is handled gracefully; does not break visitor experience | P0 |
| TC-CODE-009 | Malicious script input | Code Editor | 1. Enter a known malicious script payload<br>2. Save/Launch | Script is sandboxed/neutralized per VWO security policy; not specified which specific mitigation | P0 |
| TC-CODE-010 | Undo code changes | Code Editor with unsaved changes | 1. Make edits<br>2. Click Undo | Edits are reverted | P1 |
| TC-CODE-011 | Preview code | Code Editor | 1. Click Preview | Code is executed in preview context without affecting production | P1 |
| TC-CODE-012 | Launch with code | Campaign with saved code | 1. Launch the campaign | Code executes for visitors | P0 |
| TC-CODE-013 | Stop campaign – code no longer executes | Running campaign with code | 1. Stop the campaign<br>2. Generate traffic | Variation code no longer executes for visitors | P0 |

---

## TC-11-WGT: Widgets

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-WGT-001 | Create popup widget | Campaign or widgets section open | 1. Create a popup widget<br>2. Configure and save | Popup is created and displayed | P1 |
| TC-WGT-002 | Create banner widget | Campaign or widgets section open | 1. Create a banner widget<br>2. Save | Banner is created and displayed | P1 |
| TC-WGT-003 | Create form widget | Campaign or widgets section open | 1. Create a form widget<br>2. Save | Form is created and displayed | P1 |
| TC-WGT-004 | Create countdown timer widget | Campaign or widgets section open | 1. Create a countdown timer<br>2. Set target time<br>3. Save | Timer is created and counts down | P1 |
| TC-WGT-005 | Configure trigger | Widget created | 1. Set display trigger (e.g., on page load, on scroll) | Widget displays per the configured trigger | P1 |
| TC-WGT-006 | Configure audience for widget | Widget created | 1. Select an audience for the widget | Widget is shown only to the configured audience | P1 |
| TC-WGT-007 | Configure display frequency | Widget created | 1. Set frequency cap (e.g., show once per session) | Widget respects the frequency cap | P1 |
| TC-WGT-008 | Preview widget | Widget configured | 1. Click Preview | Widget preview is shown in the editor | P1 |
| TC-WGT-009 | Validate mobile display | Widget configured | 1. Preview on mobile viewport | Widget displays correctly on mobile | P1 |
| TC-WGT-010 | Validate desktop display | Widget configured | 1. Preview on desktop viewport | Widget displays correctly on desktop | P1 |
| TC-WGT-011 | Close widget | Widget displayed to visitor | 1. Click Close | Widget is dismissed according to config | P1 |
| TC-WGT-012 | Reopen per configured behavior | Widget closed | 1. Meet the reopen trigger condition | Widget reappears per frequency/config | P1 |
| TC-WGT-013 | Validate conversion event | Widget with a CTA | 1. Perform the widget CTA action | Conversion event is fired and tracked | P1 |
| TC-WGT-014 | Conflicting widgets | Two widgets with overlapping triggers/audiences | 1. Trigger both widgets | Conflict is resolved per priority rules (not specified) | P2 |
| TC-WGT-015 | Multiple widgets | Page with many widget-eligible visitors | 1. Trigger multiple widgets | All eligible widgets display without breaking the page | P1 |

---

## TC-19-AUD: Audience Targeting

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-AUD-001 | Single condition audience | On audience targeting UI | 1. Define one targeting condition (e.g., Device = Mobile)<br>2. Save | Audience includes only mobile visitors | P0 |
| TC-AUD-002 | AND condition audience | On audience targeting UI | 1. Define two conditions joined by AND | Visitor must match all conditions to be included | P0 |
| TC-AUD-003 | OR condition audience | On audience targeting UI | 1. Define two conditions joined by OR | Visitor matches any condition to be included | P0 |
| TC-AUD-004 | Nested conditions | On audience targeting UI | 1. Define nested AND/OR conditions | Nesting is evaluated correctly | P1 |
| TC-AUD-005 | Exclusion condition | On audience targeting UI | 1. Add an exclusion rule | Visitors matching the exclusion are excluded from the campaign | P0 |
| TC-AUD-006 | Empty audience | On audience targeting UI | 1. Attempt to save with no conditions | Save is rejected or a warning is shown (not specified) | P1 |
| TC-AUD-007 | Large audience | On audience targeting UI | 1. Define a broad audience (e.g., All visitors + many rules) | Audience is saved and evaluated correctly | P2 |
| TC-AUD-008 | Invalid condition | On audience targeting UI | 1. Enter an invalid condition (e.g., malformed regex)<br>2. Attempt to save | Validation error displayed; invalid condition rejected | P0 |
| TC-AUD-009 | Saved segment reuse | An audience segment was previously saved | 1. Select a saved segment when configuring a campaign | Segment is applied to the campaign | P1 |
| TC-AUD-010 | Reusable segment | A segment exists | 1. Use the segment in a second campaign | Segment is independently reusable | P1 |
| TC-AUD-011 | Modify audience before launch | Campaign in Draft with an audience configured | 1. Modify the audience conditions<br>2. Save | Changes are persisted | P0 |
| TC-AUD-012 | Modify audience while running | Running campaign | 1. Modify the audience conditions while running | Behavior follows campaign-edit policy (not specified if allowed) | P1 |
| TC-AUD-013 | Only eligible visitors receive campaign | Launched campaign with targeting | 1. Generate traffic from eligible and non-eligible visitors | Only eligible visitors receive the campaign experience | P0 |

---

## TC-20-TRAFFIC: Traffic Allocation

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-TRAFFIC-001 | 50/50 allocation | Campaign with 2 variations | 1. Set 50/50 allocation<br>2. Save | Allocation saved as 50/50 | P0 |
| TC-TRAFFIC-002 | 80/20 allocation | Campaign with 2 variations | 1. Set 80/20 allocation<br>2. Save | Allocation saved as 80/20 | P0 |
| TC-TRAFFIC-003 | 90/10 allocation | Campaign with 2 variations | 1. Set 90/10 allocation<br>2. Save | Allocation saved as 90/10 | P0 |
| TC-TRAFFIC-004 | 100% control | Campaign with control + variations | 1. Set 100% to control | All traffic goes to control | P1 |
| TC-TRAFFIC-005 | 100% variation | Campaign with control + variations | 1. Set 100% to one variation | All traffic goes to that variation | P1 |
| TC-TRAFFIC-006 | Multiple variations allocation | Campaign with 3+ variations | 1. Distribute traffic among all variations<br>2. Save | Allocation is saved and totals 100% | P0 |
| TC-TRAFFIC-007 | Decimal allocation | Campaign configuration | 1. Enter a decimal allocation value | Accepted if product supports decimals (not specified otherwise) | P2 |
| TC-TRAFFIC-008 | Invalid total allocation | Campaign with multiple variations | 1. Enter values totaling >100% | System rejects the configuration | P0 |
| TC-TRAFFIC-009 | Save allocation | Campaign in Draft | 1. Configure allocation<br>2. Click Save | Allocation is persisted | P0 |
| TC-TRAFFIC-010 | Modify allocation | Campaign in Draft/Ready | 1. Change the allocation<br>2. Save | New allocation is persisted | P0 |
| TC-TRAFFIC-011 | Verify actual traffic distribution | Running campaign | 1. Generate deterministic traffic<br>2. Compare actual vs. configured | Actual distribution matches configuration within statistical tolerance | P0 |
| TC-TRAFFIC-012 | Low traffic behavior | Campaign with small traffic volume | 1. Generate minimal traffic | Allocation behavior is still correct (not specified if special handling) | P1 |
| TC-TRAFFIC-013 | High traffic behavior | Running campaign | 1. Generate high traffic volume | Allocation holds and the system handles the load | P1 |

---

## TC-21-METRICS: Metrics and Goals

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-METRIC-001 | Create primary goal | On metrics configuration | 1. Add a primary goal (e.g., Page Visit)<br>2. Save | Primary goal is saved and marked primary | P0 |
| TC-METRIC-002 | Create secondary goal | On metrics configuration | 1. Add a secondary goal<br>2. Save | Secondary goal is saved | P1 |
| TC-METRIC-003 | Select existing metric | On metrics configuration | 1. Choose an existing metric from the list | Existing metric is selected and saved | P1 |
| TC-METRIC-004 | Create custom event metric | On metrics configuration | 1. Define a custom event metric<br>2. Save | Custom event metric is saved | P1 |
| TC-METRIC-005 | Track click event | Campaign with a click goal configured | 1. Click the tracked element | Click event is recorded | P0 |
| TC-METRIC-006 | Track page visit | Campaign with a page-visit goal | 1. Visit the target page | Page visit event is recorded | P0 |
| TC-METRIC-007 | Track form submission | Campaign with a form-submit goal | 1. Submit the form | Form submission event is recorded | P1 |
| TC-METRIC-008 | Track custom event | Campaign with a custom event goal | 1. Fire the custom event | Custom event is recorded | P1 |
| TC-METRIC-009 | Track revenue | Campaign with a revenue goal | 1. Complete a revenue-generating conversion | Revenue value is recorded | P0 |
| TC-METRIC-010 | Track funnel conversion | Campaign with a funnel goal | 1. Complete the funnel steps | Funnel conversion is recorded | P1 |
| TC-METRIC-011 | Multiple goals | On metrics configuration | 1. Add multiple goals to one campaign | All goals are saved and tracked | P1 |
| TC-METRIC-012 | Duplicate goals | On metrics configuration | 1. Attempt to add a goal identical to an existing one | Duplicate is rejected or a warning shown (not specified) | P2 |
| TC-METRIC-013 | Invalid goal configuration | On metrics configuration | 1. Enter an invalid goal (e.g., malformed selector)<br>2. Save | Validation error displayed; invalid goal rejected | P0 |
| TC-METRIC-014 | Delete goal | Goals configured on a campaign | 1. Delete a goal<br>2. Confirm | Goal is removed | P1 |
| TC-METRIC-015 | Change goal before launch | Campaign in Draft | 1. Change the goal configuration<br>2. Save | Changes are persisted before launch | P0 |
| TC-METRIC-016 | Verify event data | Running campaign with goals | 1. Generate conversions<br>2. Inspect raw events | Raw event data matches the fired goals | P0 |
| TC-METRIC-017 | Verify conversion count | Running campaign with traffic | 1. Generate a known number of conversions | Conversion count in the report matches | P0 |
| TC-METRIC-018 | Verify conversion rate | Running campaign with traffic | 1. Generate traffic and conversions | Conversion rate = conversions / visitors, matches report | P0 |
| TC-METRIC-019 | Verify revenue calculations | Running revenue goal campaign | 1. Generate revenue conversions with known values | Revenue totals match the sum of recorded values | P0 |

---

## TC-22-LIFECYCLE: Campaign Lifecycle (State Machine)

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-LIFE-001 | Valid state transition | Campaign in Draft | 1. Complete required setup<br>2. Move to Ready then Start | Campaign transitions Draft → Ready → Running | P0 |
| TC-LIFE-002 | Invalid state transition | Campaign in Running | 1. Attempt to directly archive a running campaign | System prevents or warns about invalid transition | P0 |
| TC-LIFE-003 | Pause running campaign | Campaign in Running | 1. Click Pause | Campaign transitions to Paused immediately | P0 |
| TC-LIFE-004 | Resume paused campaign | Campaign in Paused | 1. Click Resume | Campaign transitions back to Running | P0 |
| TC-LIFE-005 | Stop campaign | Campaign in Running or Paused | 1. Click Stop | Campaign transitions to Stopped; visitors stop receiving experience | P0 |
| TC-LIFE-006 | Restart campaign where supported | Campaign in Completed/Stopped | 1. Click Restart | Campaign transitions back to Running (where product supports) | P2 |
| TC-LIFE-007 | Edit campaign while running | Campaign in Running | 1. Attempt to edit configuration while running | Allowed edits are applied; restricted edits blocked (not specified which) | P1 |
| TC-LIFE-008 | Attempt restricted edit | Campaign in Running | 1. Attempt an edit that is not allowed at runtime | Edit is rejected with a clear message | P1 |
| TC-LIFE-009 | Verify state persistence after refresh | Campaign in any state | 1. Perform a state transition<br>2. Refresh the page | State is persisted and displayed correctly after refresh | P0 |
| TC-LIFE-010 | Verify state after logout/login | Campaign in any state | 1. Change state<br>2. Log out and back in | State is persisted across sessions | P0 |
| TC-LIFE-011 | Verify state after backend/API failure | Campaign state change attempted | 1. Trigger a state change during a backend outage<br>2. Observe outcome | State change fails safely; not specified if retry is automatic | P1 |

---

## TC-23-PREVIEW: Preview and Debugging

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-PREVIEW-001 | Preview control | Campaign with control variation | 1. Click Preview Control | Control experience is shown in preview | P0 |
| TC-PREVIEW-002 | Preview variation | Campaign with a variation | 1. Click Preview Variation | Variation experience is shown in preview | P0 |
| TC-PREVIEW-003 | Preview different devices | Campaign created | 1. Select a device type in preview | Preview renders at the selected device dimensions | P1 |
| TC-PREVIEW-004 | Preview different screen sizes | Campaign created | 1. Select/resize to a screen size | Preview renders at the selected dimensions | P1 |
| TC-PREVIEW-005 | Preview targeted audience | Campaign with audience | 1. Select an audience in preview | Preview simulates the targeted audience's experience | P1 |
| TC-PREVIEW-006 | Preview JavaScript variation | Variation with JS | 1. Preview a JS variation | JavaScript executes correctly in preview | P1 |
| TC-PREVIEW-007 | Preview CSS variation | Variation with CSS | 1. Preview a CSS variation | CSS is applied in preview | P1 |
| TC-PREVIEW-008 | Preview widgets | Campaign with a widget | 1. Preview the widget | Widget displays in preview | P1 |
| TC-PREVIEW-009 | Verify preview does not affect production metrics | Preview shown | 1. Generate "conversions" during preview<br>2. Check production report | Preview interactions are not counted in production metrics | P0 |
| TC-PREVIEW-010 | Preview not visible to normal visitors | Preview mode active | 1. Preview in one browser<br>2. Access the site normally in another browser | Normal visitors do not see the preview experience | P0 |

---

## TC-24-REPORT: Reporting

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-REPORT-001 | Report loads | Running campaign with traffic | 1. Navigate to Reports | Report page loads successfully | P0 |
| TC-REPORT-002 | Correct campaign displayed | Report page loaded | 1. Observe the report header/title | Report corresponds to the correct campaign | P0 |
| TC-REPORT-003 | Correct control displayed | Report for a campaign | 1. Observe the control row | Control data is displayed | P0 |
| TC-REPORT-004 | Correct variation displayed | Report for a campaign | 1. Observe the variation row | Variation data is displayed | P0 |
| TC-REPORT-005 | Primary metric is correct | Report page loaded | 1. Compare reported primary metric vs. independently calculated value | Primary metric is displayed (value verified against source where available) | P0 |
| TC-REPORT-006 | Secondary metrics displayed | Report page loaded | 1. Observe secondary metric values | Secondary metrics are displayed | P0 |
| TC-REPORT-007 | Conversion count displayed | Report with traffic | 1. Generate known conversions | Conversion count is shown in the report | P0 |
| TC-REPORT-008 | Conversion rate displayed | Report with traffic | 1. Generate traffic and conversions | Conversion rate is shown in the report | P0 |
| TC-REPORT-009 | Revenue displayed | Revenue-goal campaign report | 1. Generate revenue conversions | Revenue value is shown in the report | P0 |
| TC-REPORT-011 | Date filtering works | Report page loaded | 1. Apply a date range filter | Report updates to reflect the selected date range | P1 |
| TC-REPORT-012 | Segment filtering works | Report page loaded | 1. Apply a segment filter | Report updates to reflect the selected segment | P1 |
| TC-REPORT-013 | Device filtering works | Report page loaded | 1. Apply a device filter | Report updates to reflect the selected device | P1 |
| TC-REPORT-014 | Browser filtering works | Report page loaded | 1. Apply a browser filter | Report updates to reflect the selected browser | P1 |
| TC-REPORT-015 | Geographic filtering works | Report page loaded | 1. Apply a geographic filter | Report updates to reflect the selected geography | P1 |
| TC-REPORT-016 | Custom dimension filtering works | Report page loaded | 1. Apply a custom dimension filter | Report updates to reflect the selected dimension | P1 |
| TC-REPORT-017 | Report refresh works | Report page loaded | 1. Click Refresh | Report data is refreshed from the source | P1 |
| TC-REPORT-018 | Empty-data state works | Campaign with no traffic | 1. Open report for a campaign with no traffic | Empty-data state message/UI is displayed | P1 |
| TC-REPORT-019 | Large-data report works | Campaign with high traffic | 1. Open report for a high-traffic campaign | Report renders without errors and is performant | P2 |
| TC-REPORT-020 | Export works | Report page loaded | 1. Click Export | Data is exported in the selected format | P1 |
| TC-REPORT-021 | Shared report works | Report generated | 1. Share the report link | Recipient can view the (authorized) report | P1 |
| TC-REPORT-022 | Report permissions enforced | User with limited permissions | 1. Attempt to view a report | Access is granted or denied per role permissions | P0 |
| TC-REPORT-023 | Report remains consistent after campaign changes | Report open during campaign edits | 1. Edit the campaign while viewing the report<br>2. Refresh | Report reflects the updated campaign state | P1 |

---

## TC-25-STATS: Statistical Validation

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-STATS-001 | Control metrics displayed | Report with statistical data | 1. Inspect control metrics in the report | Control metrics are displayed (value verified against source where available) | P1 |
| TC-STATS-002 | Variation metrics displayed | Report with statistical data | 1. Inspect variation metrics | Variation metrics are displayed (value verified against source where available) | P1 |
| TC-STATS-003 | Difference between control and variation | Report with data | 1. Inspect the lift/difference shown | Difference value is displayed (accuracy verified with controlled dataset where available) | P1 |
| TC-STATS-004 | Probability calculations | Report with sufficient sample | 1. Inspect probability to be best | Probability value is displayed | P1 |
| TC-STATS-005 | Better-than-control classification | Report with a winning variation | 1. Inspect the winning label | Winning variation is classified correctly (per controlled dataset where available) | P1 |
| TC-STATS-006 | Worse-than-control classification | Report with a losing variation | 1. Inspect labels | Losing variation is classified as such | P1 |
| TC-STATS-007 | Practical-equivalence classification | Report with very close variants | 1. Inspect classification | Variants within practical equivalence are labelled accordingly (not specified how) | P2 |
| TC-STATS-008 | Sample size displayed | Report loaded | 1. Inspect reported sample size | Sample size value is displayed | P1 |
| TC-STATS-009 | Confidence indicators shown | Report loaded | 1. Inspect the report | Confidence level and statistical indicators are shown | P1 |
| TC-STATS-010 | Outlier handling | Report with outliers | 1. Inspect data containing outliers | Outliers are handled per the product's policy (not specified which) | P2 |
| TC-STATS-011 | Peeking safeguards | Report during a live campaign | 1. Observe statistical significance early in the run | Peeking safeguards are indicated (not specified what they are) | P2 |
| TC-STATS-012 | Segment-level statistics | Report with segment filters | 1. Apply a segment filter | Segment-specific statistics are displayed | P1 |
| TC-STATS-013 | Metric-level statistics | Report with multiple metrics | 1. Inspect each metric's statistics | Per-metric statistics are displayed | P1 |
| TC-STATS-014 | Dashboard vs. detailed report consistency | Both views available | 1. Compare the dashboard summary vs. the detailed report | Values are consistent between the two views | P0 |

---

## TC-26-FUNNEL: Funnels

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-FUNNEL-001 | Create funnel | On funnel configuration | 1. Create a new funnel | Funnel is created | P1 |
| TC-FUNNEL-002 | Add funnel steps | Funnel created | 1. Add multiple steps to the funnel | All steps are listed in order | P1 |
| TC-FUNNEL-003 | Reorder steps | Funnel with multiple steps | 1. Drag steps to reorder | Steps are reordered and persisted | P1 |
| TC-FUNNEL-004 | Remove step | Funnel with multiple steps | 1. Remove a step | Step is removed from the funnel | P1 |
| TC-FUNNEL-005 | View conversion between steps | Funnel with data | 1. Inspect the funnel | Conversion numbers are shown between each step | P1 |
| TC-FUNNEL-006 | Identify drop-off | Funnel with data | 1. Inspect the funnel | Step with the greatest drop-off is identifiable | P1 |
| TC-FUNNEL-007 | Filter funnel by audience | Funnel configured | 1. Apply an audience filter | Funnel data is filtered accordingly | P1 |
| TC-FUNNEL-008 | Filter by device | Funnel configured | 1. Apply a device filter | Funnel data is filtered by device | P1 |
| TC-FUNNEL-009 | Filter by variation | Funnel configured | 1. Apply a variation filter | Funnel data is filtered by variation | P1 |
| TC-FUNNEL-010 | Validate against raw events | Funnel with data | 1. Compare funnel numbers vs. raw event store | Funnel numbers are displayed (comparison method not specified) | P1 |
| TC-FUNNEL-011 | Validate missing-event behavior | Funnel configured | 1. Generate traffic where a step event is missing | Funnel accounts for the missing event per product logic (not specified) | P1 |
| TC-FUNNEL-012 | Validate duplicate events | Funnel configured | 1. Fire a step event twice | System handles duplicates per dedup logic (not specified) | P1 |
| TC-FUNNEL-013 | Validate out-of-order events | Funnel configured | 1. Fire events in a non-step order | System handles out-of-order events per product logic (not specified) | P1 |

---

## TC-27-HEATMAP: Heatmaps

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-HEATMAP-001 | Heatmap loads | Campaign with heatmap enabled | 1. Navigate to the heatmap view | Heatmap renders for the page | P1 |
| TC-HEATMAP-002 | Click map | Page with click data | 1. View the click map layer | Click density is shown | P1 |
| TC-HEATMAP-003 | Scroll map | Page with scroll data | 1. View the scroll map layer | Scroll depth is shown | P1 |
| TC-HEATMAP-004 | Element interaction | Heatmap loaded | 1. Inspect element-level interaction | Element interactions are shown | P1 |
| TC-HEATMAP-005 | Device filtering | Heatmap loaded | 1. Apply a device filter | Heatmap data filters by device | P1 |
| TC-HEATMAP-006 | Browser filtering | Heatmap loaded | 1. Apply a browser filter | Heatmap data filters by browser | P1 |
| TC-HEATMAP-007 | Audience filtering | Heatmap loaded | 1. Apply an audience filter | Heatmap data filters by audience | P1 |
| TC-HEATMAP-008 | Variation filtering | Heatmap with variations | 1. Apply a variation filter | Heatmap data filters by variation | P1 |
| TC-HEATMAP-009 | Dynamic elements | Heatmap on a dynamic page | 1. Interact with dynamic elements | Dynamic element clicks are captured | P1 |
| TC-HEATMAP-010 | SPA navigation | Heatmap on an SPA | 1. Navigate within the SPA | Heatmap captures virtual page views | P2 |
| TC-HEATMAP-011 | Large page | Heatmap on a large page | 1. Scroll and interact | Full-page heatmap is captured | P2 |
| TC-HEATMAP-012 | Responsive page | Heatmap on a responsive page | 1. View at different breakpoints | Heatmap reflects the responsive layout | P2 |
| TC-HEATMAP-013 | No-data state | Heatmap with no data | 1. View heatmap with no recorded visits | No-data state is shown | P1 |
| TC-HEATMAP-014 | Sensitive-data masking | Heatmap on a page with sensitive fields | 1. Inspect the heatmap | Sensitive inputs (passwords, etc.) are masked (not specified which fields) | P0 |

---

## TC-28-RECORDING: Session Recordings

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-REC-001 | Recording captured | Campaign with recording enabled | 1. Visit the site as a visitor | A session recording is captured | P0 |
| TC-REC-002 | Recording playback | Recordings available | 1. Play back a recording | Recording plays back correctly | P0 |
| TC-REC-003 | Pause/play | Recording in playback | 1. Click Pause then Play | Playback pauses and resumes | P1 |
| TC-REC-004 | Seek | Recording in playback | 1. Drag the seek bar | Playback jumps to the selected position | P1 |
| TC-REC-005 | Filter recordings | Recordings list loaded | 1. Apply a filter (e.g., by URL) | Recording list is filtered | P1 |
| TC-REC-006 | Search by user behavior | Recordings list loaded | 1. Search using behavior criteria | Matching recordings are returned | P1 |
| TC-REC-007 | Filter by device | Recordings list loaded | 1. Apply a device filter | Recordings filter by device | P1 |
| TC-REC-008 | Filter by browser | Recordings list loaded | 1. Apply a browser filter | Recordings filter by browser | P1 |
| TC-REC-009 | Filter by campaign | Recordings list loaded | 1. Apply a campaign filter | Recordings filter by campaign | P1 |
| TC-REC-010 | Filter by conversion | Recordings list loaded | 1. Apply a conversion filter | Recordings filter by conversion status | P1 |
| TC-REC-011 | Rage-click behavior | Recording with rapid clicks | 1. Inspect the recording | Rage clicks are detected/indicated (not specified how) | P2 |
| TC-REC-012 | Drop-off behavior | Recording with early exit | 1. Inspect the recording | Drop-off point is indicated | P1 |
| TC-REC-013 | Sensitive-data masking | Recording on a page with sensitive fields | 1. Play the recording | Sensitive data is masked in playback (not specified which fields) | P0 |
| TC-REC-014 | Recording deletion/retention | Recordings available | 1. Delete or wait for retention expiry | Recordings follow deletion/retention rules (not specified rules) | P1 |
| TC-REC-015 | Large recording volume | High-traffic campaign | 1. Generate many recordings | System handles and lists them without failure | P2 |
| TC-REC-016 | Playback failure handling | Recording with playback issue | 1. Attempt playback of a problematic recording | Graceful failure/message is shown | P1 |

---

## TC-29-INT: Integrations

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-INT-001 | Connect integration | Integrations page open | 1. Select and connect an integration | Integration connects successfully | P0 |
| TC-INT-002 | Authenticate integration | Integration connection started | 1. Complete the auth flow (OAuth) | Authentication succeeds; tokens are stored | P0 |
| TC-INT-003 | Validate OAuth/token behavior | Integration connected | 1. Inspect token expiry/refresh | Token refresh occurs per VWO's OAuth policy (not specified which) | P1 |
| TC-INT-004 | Validate permissions | Integration connected | 1. Inspect granted scopes | Only the granted scopes are used | P0 |
| TC-INT-005 | Import data | Integration connected | 1. Trigger an import | Data is imported | P1 |
| TC-INT-006 | Export data | Integration connected | 1. Trigger an export | Data is exported correctly | P1 |
| TC-INT-007 | Trigger event | Integration connected | 1. Trigger an event/action | Integration receives the event | P1 |
| TC-INT-008 | Verify event received | Event triggered | 1. Check the integration's side | Integration received the correct event | P1 |
| TC-INT-009 | Verify mapping | Integration triggered | 1. Inspect mapped fields/data | Data is mapped correctly | P1 |
| TC-INT-010 | Duplicate handling | Repeated events | 1. Trigger a duplicate event | Duplicates are handled per dedup logic (not specified) | P1 |
| TC-INT-011 | Invalid credentials | Integration connection | 1. Enter invalid credentials | Error message is shown; connection rejected | P0 |
| TC-INT-012 | Expired credentials | Previously connected integration with expired creds | 1. Trigger a sync | Refresh or re-authentication is prompted (not specified which) | P1 |
| TC-INT-013 | Disconnect integration | Integration connected | 1. Disconnect the integration | Integration is disconnected; data flow stops | P1 |
| TC-INT-014 | Reconnect integration | Previously disconnected integration | 1. Reconnect the integration | Data flow resumes | P1 |
| TC-INT-015 | Integration outage | Integration service unavailable | 1. Trigger a sync during outage | Failure is handled per retry policy (not specified) | P1 |
| TC-INT-016 | Retry behavior | Failed integration sync | 1. Inspect retries | Retries occur per the product's policy (not specified how many) | P1 |
| TC-INT-017 | Error messages | Failed integration operation | 1. Inspect the error | Clear error message is displayed (not specified text) | P1 |
| TC-INT-018 | Audit logs | Integration operation performed | 1. Check the audit log | Integration events are logged | P1 |

---

## TC-30-FEATURE: Feature Experimentation & Flags

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-FEAT-001 | Create feature | Features section open | 1. Create a new feature | Feature is created | P1 |
| TC-FEAT-002 | Create feature variable | Feature created | 1. Add a variable to the feature | Variable is created with a default value | P1 |
| TC-FEAT-003 | Configure default value | Feature variable created | 1. Set the default value | Default value is saved | P1 |
| TC-FEAT-004 | Configure flag | Feature created | 1. Create a feature flag | Flag is created and defaults to a state | P0 |
| TC-FEAT-005 | Enable flag | Feature flag created | 1. Toggle the flag to enabled | Flag is enabled for the environment | P0 |
| TC-FEAT-006 | Disable flag | Feature flag enabled | 1. Toggle the flag to disabled | Flag is disabled; behavior reverts to default | P0 |
| TC-FEAT-007 | Gradual rollout | Feature flag enabled | 1. Set rollout to 50% | Feature is served to ~50% of targeted users | P1 |
| TC-FEAT-008 | Instant rollback | Feature flag live | 1. Trigger an instant rollback | Feature is disabled/rolled back immediately | P0 |
| TC-FEAT-009 | Change variable at runtime | Feature flag live | 1. Change a variable value while running | New value applies for subsequent evaluations | P1 |
| TC-FEAT-010 | Validate SDK behavior | SDK integrated on site | 1. Inspect SDK calls | SDK resolves flags/variables correctly | P1 |
| TC-FEAT-011 | Validate API behavior | Feature APIs available | 1. Call the feature API | API returns correct flag/variable state | P1 |
| TC-FEAT-012 | Environment-specific behavior | Multiple environments configured | 1. Check flag state per environment | Flag behaves per-environment configuration | P1 |
| TC-FEAT-013 | User targeting | Feature flag configured | 1. Apply user targeting rules | Flag applies only to matching users | P1 |
| TC-FEAT-014 | Experiment assignment | Feature experiment configured | 1. Generate targeted traffic | Users are assigned per the experiment rules | P0 |
| TC-FEAT-015 | Persistence | Flag/variable set | 1. Verify the value persists across sessions | Value persists per the SDK's persistence policy (not specified) | P1 |
| TC-FEAT-016 | Rollback during active traffic | Flag live with traffic | 1. Trigger rollback while traffic is flowing | Rollback succeeds without breaking active visitors | P0 |

---

## TC-31-AI: AI-Assisted Features

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-AI-001 | Enter valid natural-language request | AI-assisted editor open | 1. Enter a clear variation request<br>2. Submit | AI generates a variation matching the request | P1 |
| TC-AI-002 | Generate variation | AI editor open | 1. Trigger AI generation | A variation is generated | P1 |
| TC-AI-003 | Verify generated variation matches request | Variation generated | 1. Compare the generated variation to the request | Generated content reflects the request (per anti-hallucination rules) | P1 |
| TC-AI-004 | Modify generated variation | Variation generated | 1. Edit the AI-generated variation by hand | Edits are applied | P1 |
| TC-AI-005 | Regenerate variation | AI editor open | 1. Request regeneration | A new variation is generated | P1 |
| TC-AI-006 | Generate multiple alternatives | AI editor open | 1. Request multiple alternatives | Multiple variations are generated | P2 |
| TC-AI-007 | Ambiguous prompt | AI editor open | 1. Enter an ambiguous prompt | System handles ambiguity per prompt guidance (not specified) | P2 |
| TC-AI-008 | Unsupported prompt | AI editor open | 1. Enter a clearly unsupported prompt | System returns a clear unsupported-message (not specified text) | P1 |
| TC-AI-009 | Malicious prompt | AI editor open | 1. Enter a malicious prompt | System refuses or sanitizes the request (not specified how) | P0 |
| TC-AI-010 | Prompt containing HTML/JS | AI editor open | 1. Enter a prompt with HTML/JS<br>2. Generate | Generated content is sanitized (not specified how) | P1 |
| TC-AI-011 | Unrelated element modification | AI editor open | 1. Generate a variation for a specific element | Only the targeted element is modified; others remain unchanged | P0 |
| TC-AI-012 | User approval required before launch | AI variation generated | 1. Attempt to launch with an AI-generated variation | Launch is blocked or requires explicit review/approval first | P0 |
| TC-AI-013 | Validate generated code | AI variation with code | 1. Inspect the generated code | Code is syntactically valid (per static check where available) | P1 |
| TC-AI-014 | Error handling | AI editor | 1. Cause AI generation to fail | Clear error is displayed (not specified text) | P1 |
| TC-AI-015 | Latency | AI editor | 1. Time a generation request | Latency is within acceptable limits (not specified thresholds) | P1 |
| TC-AI-016 | Usage limits | AI editor | 1. Exhaust the usage quota | System enforces limits gracefully (not specified limits) | P1 |
| TC-AI-017 | Sensitive information not exposed | AI editor | 1. Inspect AI output | No sensitive/account information is included in the output | P0 |

---

## TC-32-RBAC: User Management & RBAC

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-RBAC-001 | Administrator login | Administrator account | 1. Log in as Administrator | Full access to all areas | P0 |
| TC-RBAC-002 | Manager login | Manager account | 1. Log in as Manager | Access per Manager role permissions | P0 |
| TC-RBAC-003 | Editor login | Editor account | 1. Log in as Editor | Access per Editor role permissions | P0 |
| TC-RBAC-004 | Analyst login | Analyst account | 1. Log in as Analyst | Access per Analyst role permissions (read/reporting only) | P0 |
| TC-RBAC-005 | Viewer login | Viewer account | 1. Log in as Viewer | Read-only access per Viewer role | P0 |
| TC-RBAC-006 | Restricted/custom role login | Custom role account | 1. Log in with custom role | Access per custom role permissions | P1 |
| TC-RBAC-007 | Role: dashboard access | Any authenticated role | 1. Navigate to dashboard | Access granted to dashboard per role | P0 |
| TC-RBAC-008 | Role: campaign creation | Role with create permission | 1. Create a campaign | Creation succeeds; roles without create see it disabled/blocked | P0 |
| TC-RBAC-009 | Role: campaign editing | Role with edit permission | 1. Edit a campaign | Edit permitted; roles without edit are blocked | P0 |
| TC-RBAC-010 | Role: campaign launch | Role with launch permission | 1. Launch a campaign | Launch permitted; roles without launch are blocked | P0 |
| TC-RBAC-011 | Role: campaign pause | Role with pause permission | 1. Pause a campaign | Pause permitted; roles without pause are blocked | P0 |
| TC-RBAC-012 | Role: campaign deletion | Role with delete permission | 1. Delete a campaign | Deletion permitted; roles without delete are blocked | P0 |
| TC-RBAC-013 | Role: report access | Role with report permission | 1. Access reports | Reports accessible; roles without see them blocked | P0 |
| TC-RBAC-014 | Role: account settings | Role with settings permission | 1. Access account settings | Settings accessible; roles without are blocked | P1 |
| TC-RBAC-015 | Role: user management | Role with user-mgmt permission | 1. Access user management | Accessible; roles without are blocked | P0 |
| TC-RBAC-016 | Role: integration management | Role with integration permission | 1. Manage integrations | Accessible; roles without are blocked | P1 |
| TC-RBAC-017 | Role: export access | Role with export permission | 1. Export data | Export permitted; roles without are blocked | P1 |
| TC-RBAC-018 | Role: audit/history access | Role with audit permission | 1. Access audit/history | Accessible; roles without are blocked | P1 |
| TC-RBAC-019 | Negative: unauthorized campaign edit via UI | Role without edit permission | 1. Attempt to edit a campaign via UI | Action is blocked/disabled | P0 |
| TC-RBAC-020 | Negative: unauthorized campaign edit via direct API | Role without edit permission | 1. Call the campaign update API directly | API returns 403 Forbidden; no change is applied | P0 |

---

## TC-33-SECURITY: Security Testing

### Authentication

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-SEC-AUTH-001 | Brute-force protection | Login page available | 1. Submit many incorrect login attempts | Account is locked or throttled per VWO policy (not specified limits) | P0 |
| TC-SEC-AUTH-002 | Password policy | On login/signup | 1. Attempt a weak password | Password is rejected per policy rules (not specified rules) | P0 |
| TC-SEC-AUTH-003 | Session management | User logged in | 1. Inspect session cookie/token | Session is managed securely (not specified mechanism) | P1 |
| TC-SEC-AUTH-004 | Session timeout | User logged in | 1. Remain idle past the timeout | Session expires and user is logged out | P0 |
| TC-SEC-AUTH-005 | Concurrent sessions | User logged in elsewhere | 1. Log in from a second device/browser | Behavior follows VWO policy (not specified) | P1 |
| TC-SEC-AUTH-006 | Logout invalidation | User logged in | 1. Log out<br>2. Attempt to use the old session | Old session is invalidated | P0 |
| TC-SEC-AUTH-007 | MFA | Account with MFA enabled | 1. Log in with MFA enabled | MFA challenge is presented and required | P0 |

### Authorization

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-SEC-AUTHZ-001 | Horizontal privilege escalation | Two users in the same org | 1. User A attempts to access User B's campaign | Access is denied | P0 |
| TC-SEC-AUTHZ-002 | Vertical privilege escalation | Low-level user | 1. User attempts an admin-only action | Access is denied | P0 |
| TC-SEC-AUTHZ-003 | Direct URL access | Non-authenticated session | 1. Navigate directly to a protected URL | Redirected to login / access denied | P0 |
| TC-SEC-AUTHZ-004 | Direct API access | Unauthorized caller | 1. Call a protected API without a valid token | API returns 401/403 | P0 |
| TC-SEC-AUTHZ-005 | Object-level authorization | User with access to some objects | 1. Attempt to access an object not owned/assigned | Access denied for unauthorized objects | P0 |

### Input Security

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-SEC-INPUT-001 | Reflected XSS | Any input field | 1. Submit a reflected XSS payload via the URL/query | Payload is escaped/sanitized; no execution | P0 |
| TC-SEC-INPUT-002 | Stored XSS | Any stored input (e.g., campaign name) | 1. Save a stored XSS payload<br>2. View the stored value | Payload is escaped/sanitized on display; no execution | P0 |
| TC-SEC-INPUT-003 | HTML injection | Any input field | 1. Submit an HTML injection payload | Payload is escaped/sanitized; no injection | P0 |
| TC-SEC-INPUT-004 | JavaScript injection | Code editor / custom HTML widget | 1. Submit a JS injection payload | Payload is sandboxed/neutralized per VWO policy (not specified) | P0 |
| TC-SEC-INPUT-005 | Special characters | Any input field | 1. Submit special characters in a name | Special characters are handled safely | P1 |
| TC-SEC-INPUT-006 | Unicode and emoji | Any input field | 1. Submit Unicode/emoji characters | Characters are stored and displayed correctly | P2 |
| TC-SEC-INPUT-007 | Extremely long input | Any input field | 1. Submit an extremely long string | System enforces length limits or truncates (not specified) | P1 |
| TC-SEC-INPUT-008 | Invalid JavaScript (code editor) | Code editor open | 1. Enter invalid JS and save/launch | Invalid JS does not break the customer page (sandboxed) | P0 |

### Data Security

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-SEC-DATA-001 | HTTPS | Any page load | 1. Inspect network traffic | All traffic is served over HTTPS (not specified which endpoints) | P0 |
| TC-SEC-DATA-002 | Sensitive data masking | Pages with sensitive data | 1. Inspect UI/logs | Sensitive data is masked (not specified which fields) | P0 |
| TC-SEC-DATA-003 | Token protection | Authenticated session | 1. Inspect tokens in the browser | Tokens are stored securely (not specified mechanism) | P0 |
| TC-SEC-DATA-004 | API credential protection | API settings | 1. Inspect how credentials are stored/displayed | Credentials are masked and protected (not specified how) | P0 |
| TC-SEC-DATA-005 | PII handling | PII present in data | 1. Inspect data flows | PII is handled per privacy policy (not specified rules) | P1 |
| TC-SEC-DATA-006 | Session recording privacy | Recording on a page with sensitive fields | 1. Record and play back | Sensitive fields are masked in recordings | P0 |
| TC-SEC-DATA-007 | Data export authorization | Export feature available | 1. User without export permission attempts export | Export is blocked; users with permission can export | P0 |
| TC-SEC-DATA-008 | Audit logs | Admin account | 1. Inspect audit logs after an action | Action is logged (not specified log detail) | P1 |

---

## TC-34-API: API Testing

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-API-001 | API authentication | API endpoint available | 1. Call endpoint without credentials | 401 Unauthenticated | P0 |
| TC-API-002 | API authorization | Authenticated non-admin user | 1. Call an admin-only endpoint | 403 Unauthorized | P0 |
| TC-API-003 | HTTP methods | Any API endpoint | 1. Send an unsupported method (e.g., DELETE on a read-only resource) | 405 Method Not Allowed (not specified which codes) | P1 |
| TC-API-004 | Status codes | Any API endpoint | 1. Perform valid and invalid operations per the example codes in the plan | 200/201 for success; 400/401/403/404/409/429/500 as described | P0 |
| TC-API-005 | Headers | Any API request | 1. Inspect response headers | Required headers are present and correctly set (not specified which) | P1 |
| TC-API-006 | Request schema validation | API endpoint accepting payloads | 1. Send a well-formed request | Request is accepted | P0 |
| TC-API-007 | Response schema validation | Any API call | 1. Inspect the response | Response matches the documented schema (not specified schema) | P0 |
| TC-API-008 | Required fields | API endpoint with required fields | 1. Omit a required field | 400 Bad Request | P0 |
| TC-API-009 | Optional fields | API endpoint with optional fields | 1. Omit optional fields | Request succeeds | P1 |
| TC-API-010 | Boundary values | API field with min/max length | 1. Send values at the boundaries (empty, 1, max, max+1) | Boundaries are handled as documented (not specified limits) | P1 |
| TC-API-011 | Invalid payloads | Any API endpoint | 1. Send a malformed payload | 400 Bad Request | P0 |
| TC-API-012 | Duplicate requests | Idempotent endpoint | 1. Send the same request twice | Second request is idempotent (not specified behavior) | P1 |
| TC-API-013 | Idempotency | Idempotent endpoint | 1. Send a request with an idempotency key | Repeat requests return the same result | P1 |
| TC-API-014 | Pagination | List endpoint returning many items | 1. Request page 2 with a limit | Correct subset of items is returned | P1 |
| TC-API-015 | Sorting | List endpoint | 1. Request sorting by a field | Results are sorted correctly | P1 |
| TC-API-016 | Filtering | List endpoint | 1. Apply a filter query param | Results are filtered correctly | P1 |
| TC-API-017 | Rate limiting | Any API endpoint | 1. Send many rapid requests | 429 Too Many Requests after exceeding limits (not specified) | P1 |
| TC-API-018 | Error responses | Any API endpoint | 1. Trigger an error condition | Error response body is descriptive (not specified format) | P1 |
| TC-API-019 | Timeout behavior | Any API endpoint | 1. Send a request during high latency | Client/server handles timeout (not specified timeout values) | P1 |
| TC-API-020 | Retry behavior | Flaky API endpoint | 1. Trigger a transient failure | Retries occur per policy (not specified policy) | P1 |
| TC-API-021 | API version compatibility | Two API versions | 1. Call v1 vs v2 of an endpoint | Both versions behave as documented (not specified) | P2 |

---

## TC-35-DATA: Database/Data Validation

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-DATA-001 | Campaign exists in backend | Campaign created in UI | 1. Inspect the backend data store for the campaign (not specified how) | Campaign record exists | P0 |
| TC-DATA-002 | Campaign update persists | Updated campaign | 1. Update a campaign<br>2. Inspect backend | Updated values are persisted | P0 |
| TC-DATA-003 | Variation config persists | Saved variation | 1. Inspect backend for variation | Variation configuration is persisted | P0 |
| TC-DATA-004 | Audience config persists | Saved audience | 1. Inspect backend for audience | Audience configuration is persisted | P0 |
| TC-DATA-005 | Metrics persist | Saved metric | 1. Inspect backend for metric | Metric definition is persisted | P0 |
| TC-DATA-006 | Events not duplicated | Multiple event firings | 1. Fire events that arrive close together | Events are stored once (deduplicated) per VWO logic (not specified) | P0 |
| TC-DATA-007 | Deleted entities follow retention | Deleted campaign/event | 1. Delete an entity<br>2. Inspect retention | Entity follows deletion/retention rules (not specified rules) | P1 |
| TC-DATA-008 | Campaign state consistent | Running campaign | 1. Inspect backend state | State matches what the UI reports | P0 |
| TC-DATA-009 | User permissions consistent | User with role | 1. Inspect backend permissions | Permissions match the configured role | P0 |
| TC-DATA-010 | Report aggregates match source | Report with data | 1. Compare report aggregates vs. raw events (not specified how) | Aggregates match source events | P0 |

---

## TC-36-PERF: Performance Testing

### Application

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-PERF-APP-001 | Dashboard page load time | Logged-in user | 1. Measure dashboard load time | Within acceptable limits (not specified thresholds) | P1 |
| TC-PERF-APP-002 | Time to interactive | Dashboard open | 1. Measure TTI | Within acceptable limits (not specified thresholds) | P1 |
| TC-PERF-APP-003 | API response time | Any API call | 1. Measure response time | Within acceptable limits (not specified thresholds) | P1 |
| TC-PERF-APP-004 | Campaign creation time | Campaign creation flow | 1. Create a campaign and time it | Within acceptable limits (not specified thresholds) | P2 |
| TC-PERF-APP-005 | Report generation time | Report page open | 1. Generate a report and time it | Within acceptable limits (not specified thresholds) | P2 |
| TC-PERF-APP-006 | Editor loading time | Editor opened | 1. Open the visual editor and time it | Within acceptable limits (not specified thresholds) | P2 |
| TC-PERF-APP-007 | Preview loading time | Preview triggered | 1. Load a preview and time it | Within acceptable limits (not specified thresholds) | P2 |
| TC-PERF-APP-008 | Export generation time | Export triggered | 1. Generate and download an export | Within acceptable limits (not specified thresholds) | P2 |

### Experiment Runtime

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-PERF-RUN-001 | SmartCode impact | Live campaign on site | 1. Measure SmartCode load impact on page | Within acceptable limits (not specified thresholds) | P1 |
| TC-PERF-RUN-002 | Variation rendering time | Live campaign | 1. Measure variation render time | Within acceptable limits (not specified thresholds) | P1 |
| TC-PERF-RUN-003 | Assignment latency | Live campaign | 1. Measure visitor assignment latency | Within acceptable limits (not specified thresholds) | P1 |
| TC-PERF-RUN-004 | Event transmission latency | Live campaign | 1. Measure event transmission latency | Within acceptable limits (not specified thresholds) | P1 |
| TC-PERF-RUN-005 | Analytics processing delay | Live campaign | 1. Measure end-to-end analytics delay | Within acceptable limits (not specified thresholds) | P2 |

### Load Tests

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-PERF-LOAD-001 | 100 concurrent users | Test environment ready | 1. Simulate 100 concurrent visitors | System handles load without errors | P2 |
| TC-PERF-LOAD-002 | 500 concurrent users | Test environment ready | 1. Simulate 500 concurrent visitors | System handles load without errors | P2 |
| TC-PERF-LOAD-003 | 1,000 concurrent users | Test environment ready | 1. Simulate 1,000 concurrent visitors | System handles load without errors | P2 |
| TC-PERF-LOAD-004 | Large campaign volume | Test environment ready | 1. Create/run a large campaign | No degradation | P2 |
| TC-PERF-LOAD-005 | Large event volume | Live campaign | 1. Generate a high volume of events | Events are ingested without loss (not specified which) | P2 |
| TC-PERF-LOAD-006 | High report traffic | Report page open by many | 1. Concurrently access reports | Reports render correctly | P2 |
| TC-PERF-LOAD-007 | Concurrent campaign launches | Multiple campaigns ready | 1. Launch multiple campaigns concurrently | All launch successfully | P2 |

---

## TC-37-RELIABILITY: Reliability Testing

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-REL-001 | Network interruption | Campaign save in progress | 1. Interrupt the network during a save | Save fails gracefully; data not corrupted (not specified rollback) | P1 |
| TC-REL-002 | API timeout | Any API call | 1. Simulate an API timeout | Timeout handled gracefully; user notified | P1 |
| TC-REL-003 | Backend service unavailable | Any backend operation | 1. Simulate backend outage | Operation fails safely | P1 |
| TC-REL-004 | Browser refresh during save | Save in progress | 1. Refresh the browser mid-save | Save state is handled consistently (not specified which) | P1 |
| TC-REL-005 | Browser close during save | Save in progress | 1. Close the browser mid-save | Save either completes or rolls back safely; not corrupted | P1 |
| TC-REL-006 | Duplicate submission | Form submitted | 1. Submit the same form twice quickly | Second submission is rejected or idempotently handled | P1 |
| TC-REL-007 | Partial integration failure | Integration configured | 1. Simulate partial integration failure | Other functionality unaffected; failure is reported | P1 |
| TC-REL-008 | Analytics service failure | Analytics integration active | 1. Simulate analytics service outage | VWO continues; analytics data may be delayed/retryable | P1 |
| TC-REL-009 | Event ingestion failure | Event being sent | 1. Simulate ingestion failure | Retry occurs per policy (not specified) | P1 |
| TC-REL-010 | Recovery after outage | Backend service out then back in | 1. Restore service after outage | Recovery occurs automatically; data is consistent (not specified how) | P1 |
| TC-REL-011 | Retry behavior | Failed operation | 1. Inspect retries | Retries occur per the product's retry policy (not specified) | P1 |
| TC-REL-012 | Data consistency after recovery | After a failure/recovery cycle | 1. Inspect data integrity | Data is consistent after recovery | P0 |

---

## TC-COMP: Compatibility Testing

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-COMP-001 | Chrome latest | Chrome browser available | 1. Run key flows in Chrome latest | All features function correctly | P1 |
| TC-COMP-002 | Edge latest | Edge browser available | 1. Run key flows in Edge latest | All features function correctly | P1 |
| TC-COMP-003 | Firefox latest | Firefox browser available | 1. Run key flows in Firefox latest | All features function correctly | P1 |
| TC-COMP-004 | Safari latest | Safari browser available | 1. Run key flows in Safari latest | All features function correctly | P1 |
| TC-COMP-005 | Responsive at 320px | Responsive test | 1. Load pages at 320px width | Layout is usable at 320px | P1 |
| TC-COMP-006 | Responsive at 375px | Responsive test | 1. Load pages at 375px width | Layout is usable at 375px | P1 |
| TC-COMP-007 | Responsive at 1920px | Responsive test | 1. Load pages at 1920px width | Layout is usable at 1920px | P1 |
| TC-COMP-008 | Tablet display | Tablet available | 1. Access VWO on a tablet | UI is usable on tablet | P1 |
| TC-COMP-009 | Mobile display | Mobile device available | 1. Access VWO on a phone | UI is usable on mobile | P1 |

---

## TC-ACC: Accessibility Testing

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-ACC-001 | Keyboard-only navigation | VWO UI loaded | 1. Navigate using only Tab/Enter | All interactive elements are reachable | P1 |
| TC-ACC-002 | Tab order | VWO UI loaded | 1. Press Tab through the page | Focus moves in a logical order | P1 |
| TC-ACC-003 | Focus visibility | Keyboard navigation | 1. Tab through and observe focus | Focused element has a visible outline | P1 |
| TC-ACC-004 | Screen reader support | NVDA/VoiceOver available | 1. Navigate with a screen reader | Content is announced correctly (not specified exactly) | P1 |
| TC-ACC-005 | Form labels | Form fields present | 1. Inspect labels for inputs | Each input has an associated label | P1 |
| TC-ACC-006 | Error messages | Form with errors | 1. Trigger a validation error | Error is announced to screen readers | P1 |
| TC-ACC-007 | Color contrast | VWO UI | 1. Check contrast ratios | Meets WCAG AA minimums | P1 |
| TC-ACC-008 | Accessible buttons/links | UI with buttons/links | 1. Inspect buttons/links | Properly marked up as button/link roles | P1 |
| TC-ACC-009 | Modal focus management | Modal open | 1. Open a modal dialog | Focus is trapped within the modal | P1 |
| TC-ACC-010 | Escape key behavior | Modal open | 1. Press Escape | Modal closes | P1 |
| TC-ACC-011 | ARIA attributes | UI with dynamic content | 1. Inspect ARIA attributes | ARIA is applied correctly (not specified which) | P1 |
| TC-ACC-012 | Zoom to 200% | VWO UI | 1. Zoom page to 200% | Content reflows without loss of functionality | P1 |
| TC-ACC-013 | Dynamic content announcements | Dynamic UI | 1. Trigger dynamic content changes | Changes are announced to screen readers | P1 |

---

## TC-UX: UX Testing

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-UX-001 | Navigation clarity | VWO UI loaded | 1. Navigate between sections | Navigation is clear and consistent | P2 |
| TC-UX-002 | Terminology consistency | VWO UI | 1. Inspect labels across screens | Terms are used consistently | P2 |
| TC-UX-003 | Error-message clarity | Any error state | 1. Trigger an error | Message is clear and actionable (not specified text) | P1 |
| TC-UX-004 | Empty states | No data scenario | 1. View an empty list/page | Appropriate empty-state guidance is shown | P2 |
| TC-UX-005 | Loading states | Any async operation | 1. Trigger a load | Loading indicator is shown | P1 |
| TC-UX-006 | Confirmation messages | Destructive action available | 1. Complete a destructive action | Confirmation is shown | P1 |
| TC-UX-007 | Destructive-action warnings | Delete/archive available | 1. Initiate a destructive action | Warning dialog is shown before proceeding | P0 |
| TC-UX-008 | Unsaved-change warnings | Form with edits | 1. Attempt to navigate away with unsaved changes | Warning dialog is shown | P1 |
| TC-UX-009 | Discoverability of features | VWO UI | 1. Explore the UI | Key features are discoverable (not specified which) | P2 |
| TC-UX-010 | Consistency between screens | Multiple VWO screens | 1. Compare layouts | UI is consistent across screens | P2 |

---

## TC-NEG: Negative Testing

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-NEG-001 | Invalid URL | Campaign creation | 1. Enter a malformed URL | Validation error; save rejected | P0 |
| TC-NEG-002 | Invalid JavaScript | Code editor | 1. Enter invalid JS | Sanitized/handled; does not break page | P0 |
| TC-NEG-003 | Invalid CSS | Code editor | 1. Enter invalid CSS | Handled gracefully (not specified how) | P1 |
| TC-NEG-004 | Invalid HTML | Code editor / custom HTML | 1. Enter invalid HTML | Handled gracefully (not specified how) | P1 |
| TC-NEG-005 | Invalid audience condition | Audience targeting | 1. Enter an invalid condition | Validation error; rejected | P0 |
| TC-NEG-006 | Invalid metric | Metrics config | 1. Configure an invalid metric | Validation error; rejected | P0 |
| TC-NEG-007 | Invalid traffic allocation | Traffic allocation UI | 1. Enter >100% total | Rejected with error | P0 |
| TC-NEG-008 | Duplicate campaign | Campaign creation | 1. Attempt to duplicate an existing name | Warning or rejection (not specified) | P1 |
| TC-NEG-009 | Missing required field | Any form | 1. Submit with a required field empty | Validation error; submission blocked | P0 |
| TC-NEG-010 | Expired session | Logged-in session expired | 1. Perform an action after session expiry | Action is rejected; user re-authenticated | P0 |
| TC-NEG-011 | Unauthorized campaign access | User A | 1. Attempt to access User B's campaign | Access denied | P0 |
| TC-NEG-012 | Unauthorized API request | Unprivileged user | 1. Call an admin API | 403 Forbidden | P0 |
| TC-NEG-013 | Broken integration | Integration configured | 1. Simulate a broken integration | Failure handled per retry/error policy (not specified) | P1 |
| TC-NEG-014 | Network interruption | Any operation | 1. Interrupt the network | Failure handled gracefully | P1 |
| TC-NEG-015 | Backend timeout | Any operation | 1. Simulate a timeout | Handled gracefully | P1 |

---

## TC-BND: Boundary Value Testing

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-BND-001 | Campaign name: empty | Campaign creation form | 1. Leave campaign name empty | Rejected | P0 |
| TC-BND-002 | Campaign name: 1 char | Campaign creation form | 1. Enter 1-character name | Accepted | P1 |
| TC-BND-003 | Campaign name: max length | Campaign creation form | 1. Enter max-length name (not specified length) | Accepted | P1 |
| TC-BND-004 | Campaign name: max+1 | Campaign creation form | 1. Enter max-length+1 characters | Rejected | P1 |
| TC-BND-005 | Traffic: 0% | Traffic allocation | 1. Set 0% | Accepted (no traffic to this variation) | P1 |
| TC-BND-006 | Traffic: 1% | Traffic allocation | 1. Set 1% | Accepted | P0 |
| TC-BND-007 | Traffic: 99% | Traffic allocation | 1. Set 99% | Accepted | P0 |
| TC-BND-008 | Traffic: 100% | Traffic allocation | 1. Set 100% | Accepted | P0 |
| TC-BND-009 | Traffic: >100% | Traffic allocation | 1. Set total >100% | Rejected | P0 |
| TC-BND-010 | Variations: 0 | Variation editor | 1. Attempt 0 variations | Rejected | P0 |
| TC-BND-011 | Variations: 1 | Variation editor | 1. Add 1 variation | Accepted | P0 |
| TC-BND-012 | Variations: maximum | Variation editor | 1. Add maximum allowed (not specified count) | Accepted | P1 |
| TC-BND-013 | Variations: maximum+1 | Variation editor | 1. Add one more than maximum | Rejected | P1 |
| TC-BND-014 | Audience rules: 0 | Audience builder | 1. Attempt 0 rules | Rejected or warned (not specified) | P1 |
| TC-BND-015 | Audience rules: 1 | Audience builder | 1. Add 1 rule | Accepted | P0 |
| TC-BND-016 | Metrics: 0 | Metrics config | 1. Attempt 0 metrics | Rejected (primary is required) | P0 |
| TC-BND-017 | Metrics: 1 | Metrics config | 1. Add 1 metric | Accepted | P0 |
| TC-BND-018 | URL: empty | Split URL config | 1. Leave URL empty | Rejected | P0 |
| TC-BND-019 | URL: extremely long | Any URL field | 1. Enter an extremely long URL | Rejected or truncated (not specified) | P1 |
| TC-BND-020 | API payload: empty | Any API endpoint | 1. Send empty payload | 400 Bad Request | P1 |
| TC-BND-021 | API payload: minimum | Any API endpoint | 1. Send minimal valid payload | 200/201 Success | P1 |
| TC-BND-022 | API payload: maximum | Any API endpoint | 1. Send maximum-size payload | Accepted or rejected per limits (not specified) | P2 |
| TC-BND-023 | API payload: malformed | Any API endpoint | 1. Send malformed JSON | 400 Bad Request | P0 |

---

## TC-E2E: End-to-End Business Scenarios

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-E2E-001 | Basic A/B experiment | Valid VWO account | 1. Login<br>2. Create A/B campaign<br>3. Enter target URL<br>4. Open Visual Editor<br>5. Create variation<br>6. Configure audience<br>7. Configure traffic 50/50<br>8. Configure primary metric<br>9. Preview<br>10. Save<br>11. Launch<br>12. Generate test traffic<br>13. Verify visitor assignment<br>14. Verify conversion event<br>15. Open report<br>16. Verify metrics<br>17. Share/export report<br>18. Stop campaign<br>19. Verify final state | Full A/B experiment lifecycle completes successfully from creation through report | P0 |
| TC-E2E-002 | Targeted experiment | Valid VWO account | 1. Create campaign<br>2. Configure mobile audience<br>3. Configure geographic audience<br>4. Create variation<br>5. Launch<br>6. Test eligible visitor<br>7. Test non-eligible visitor<br>8. Validate assignment<br>9. Validate metrics<br>10. Validate report segmentation | Only eligible visitors are targeted; reports are correctly segmented | P0 |
| TC-E2E-003 | Experiment to rollout | Valid VWO account | 1. Create experiment<br>2. Run experiment<br>3. Collect traffic<br>4. Analyze report<br>5. Identify winning variation<br>6. Configure rollout<br>7. Publish<br>8. Verify production experience<br>9. Verify rollback capability | Winner is rolled out to production; rollback is reversible | P0 |
| TC-E2E-004 | Integration | Valid VWO account | 1. Configure analytics integration<br>2. Authenticate<br>3. Create campaign<br>4. Launch<br>5. Generate conversion<br>6. Verify VWO event<br>7. Verify external analytics event<br>8. Compare data<br>9. Disconnect integration<br>10. Validate failure behavior | Data flows correctly to the integration; disconnection is handled | P0 |

---

## TC-REG: Regression Test Suite

### P0 Regression

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-REG-P0-001 | Login regression | Account credentials | Run the login flow end-to-end | Login succeeds | P0 |
| TC-REG-P0-002 | Dashboard regression | Logged-in user | Navigate to and interact with the dashboard | Dashboard renders correctly | P0 |
| TC-REG-P0-003 | Campaign creation regression | Logged-in user | Create a campaign end-to-end | Campaign is created | P0 |
| TC-REG-P0-004 | A/B test regression | Logged-in user | Create an A/B test, configure variations, launch | A/B test runs correctly | P0 |
| TC-REG-P0-005 | Variation creation regression | A/B campaign open | Create a variation in the editor | Variation is created and saved | P0 |
| TC-REG-P0-006 | Audience regression | Campaign open | Configure and save an audience | Audience is configured correctly | P0 |
| TC-REG-P0-007 | Traffic allocation regression | Campaign open | Configure and save traffic allocation | Allocation is saved correctly | P0 |
| TC-REG-P0-008 | Metrics regression | Campaign open | Add primary metric, save, verify | Metrics are tracked correctly | P0 |
| TC-REG-P0-009 | Preview regression | Campaign with variation | Launch preview | Preview shows the correct experience | P0 |
| TC-REG-P0-010 | Launch regression | Campaign in Ready | Launch the campaign | Campaign starts running | P0 |
| TC-REG-P0-011 | Pause regression | Running campaign | Pause the campaign | Campaign pauses correctly | P0 |
| TC-REG-P0-012 | Report regression | Running campaign with traffic | View report | Report displays correct data | P0 |
| TC-REG-P0-013 | Export regression | Report with data | Export the report | Export completes with correct data | P0 |
| TC-REG-P0-014 | Permissions regression | Logged-in user with role | Verify role-based access | Permissions are enforced correctly | P0 |
| TC-REG-P0-015 | Logout regression | Logged-in user | Log out | Session is terminated | P0 |

### P1 Regression

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-REG-P1-001 | Split URL regression | Logged-in user | Create a Split URL test | Test is created and functional | P1 |
| TC-REG-P1-002 | Multivariate regression | Logged-in user | Create an MVT test | Test is created and functional | P1 |
| TC-REG-P1-003 | Code editor regression | Campaign open | Add valid JS/CSS, save, launch | Code executes correctly | P1 |
| TC-REG-P1-004 | Widgets regression | Campaign open | Add a widget, configure, preview | Widget functions correctly | P1 |
| TC-REG-P1-005 | Funnels regression | Report with data | View funnel | Funnel data is correct | P1 |
| TC-REG-P1-006 | Heatmaps regression | Campaign with data | View heatmap | Heatmap renders correctly | P1 |
| TC-REG-P1-007 | Recordings regression | Campaign with data | Play a recording | Recording plays correctly | P1 |
| TC-REG-P1-008 | Integrations regression | Integration configured | Trigger and verify data flow | Integration works correctly | P1 |
| TC-REG-P1-009 | Scheduling regression | Campaign open | Configure scheduling | Schedule is saved and enforced | P1 |
| TC-REG-P1-010 | Advanced targeting regression | Campaign open | Configure advanced targeting | Targeting is applied correctly | P1 |

---

## ANTI-Hallucination RULES Compliance Notes

- Where the source test plan does **not** specify a value, mechanism, threshold, or tool, the corresponding test case states **"Not specified"** rather than asserting an assumed behavior.
- Test case expected results are derived **only** from the sections of `VWO_Detailed_Test_Plan.md`.
- Test IDs are mapped to plan sections for traceability (e.g., TC-13-* maps to plan §13, TC-AUTH-* maps to plan §10.1, etc.).
- The format column order follows the template exactly: `| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |`.
