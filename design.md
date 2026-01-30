# Design system

```text
+-------------------+
|   Process Engine  |
|  (BPMN Workflow)  |
+---------+---------+
          |
          v
+-------------------+
|   Rule Engine     |
| (Business Rules)  |
+---------+---------+
          |
          v
+-------------------+        (offline / batch)
|    Event Logs     | ----------------------+
+-------------------+                       |
                                            v
                                   +-------------------+
                                   |    AI Module      |
                                   | (Recommendation)  |
                                   +---------+---------+
                                             |
                                       Human approval
                                             |
                                             v
                                     Update Business Rules

```
Nền tảng bao gồm Process Engine điều phối quy trình, Rule Engine thực thi luật nghiệp vụ tại các điểm ra quyết định, và module AI hoạt động offline để phân tích dữ liệu vận hành và đề xuất điều chỉnh luật theo cơ chế human-in-the-loop

```text
[Receive CV]
      |
      v
[Screening] ----(Rule Engine)----> Reject
      |
      v
[Interview] ----(Rule Engine)----> Reject
      |
      v
[Offer & Onboard]
      |
      v
[Probation Review] --(Rule Engine)--> Fail / Pass

```

AI không tham gia trực tiếp vào luồng BPMN mà phân tích dữ liệu vận hành và kết quả quyết định để hỗ trợ cải tiến luật nghiệp vụ