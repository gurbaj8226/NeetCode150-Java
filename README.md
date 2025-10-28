# NeetCode 150 – Java

My step-by-step **NeetCode 150** journey in Java — focused on interview prep, algorithmic fluency, and clean, well-documented solutions.

---

## Categories Progress

| Category | Status | Notes |
|-----------|---------|-------|
| Arrays & Hashing | ✅ Started | Finished Two Sum |
| Two Pointers | ✅ Active | Valid Palindrome, Two Sum II, Container With Most Water |
| Sliding Window | ✅ Active | Best Time to Buy/Sell Stock, Longest Substring, Permutation in String, Minimum Window Substring |
| Stack | 🔜 Next | Valid Parentheses, Min Stack upcoming |

---

## ⚙️ Project Structure
Each folder contains:
- Java solution (`.java`)
- Problem-specific README (Approach / Complexity / Edge Cases)
- Future JUnit tests

---

## 🧮 Arrays & Hashing

| # | Problem | Approach | Time | Space | Key Idea |
|---|----------|-----------|-------|--------|-----------|
| 1 | Two Sum | HashMap | O(N) | O(N) | Store complements to find pair |

---

## 🪞 Two Pointers

| # | Problem | Approach | Time | Space | Key Idea |
|---|----------|-----------|-------|--------|-----------|
| 125 | Valid Palindrome | Two Pointers | O(N) | O(1) | Skip non-alphanumeric chars |
| 167 | Two Sum II – Input Array Is Sorted | Two Pointers | O(N) | O(1) | Move left/right based on sum |
| 11 | Container With Most Water | Two Pointers | O(N) | O(1) | Move shorter wall inward |

---

## 🌬 Sliding Window

| # | Problem | Approach | Time | Space | Key Idea |
|---|----------|-----------|-------|--------|-----------|
| 121 | Best Time to Buy and Sell Stock | Sliding Window | O(N) | O(1) | Track min price and max profit |
| 3 | Longest Substring Without Repeating Characters | Variable Window | O(N) | O(N) | Expand right until duplicate |
| 567 | Permutation in String | Fixed Window | O(N) | O(1) | Compare char freq arrays |
| 76 | Minimum Window Substring | Variable Window | O(N) | O(K) | Expand until have == need, then shrink |

---

## 🧠 Sliding Window Insights
1. Maintain the **window invariant** — what must stay true as you expand/shrink.
2. **LC 3:** Remove before incrementing `left` to avoid duplicates.
3. **LC 567:** Fixed window → no while-loop shrink.
4. **LC 76:** Shrink once `have == need`.
5. **LC 121:** Treat buy/sell as a two-pointer variant of window minimization.

---

## 🗓 Progress Tracker
> **Goal:** Finish NeetCode 150 by Jan 1 2026
> **Current:** 7 / 150 problems completed (4 Sliding Window, 3 Two Pointers, 1 Hashing)
> **Next:** Stack category starts late October → Valid Parentheses and Min Stack

---

## 🧩 Future Enhancements
- Add JUnit tests per problem
- Automate README table updates with Python/Maven script
- Add progress badge & daily tracker section

---