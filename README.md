# Todo — Android Sample App

A small single-user to-do list app: capture the things you need to do, tick them off as you go, and see how much is left. The app is deliberately simple on the surface so it can double as a clean reference for how a modern Android app is put together (Jetpack Compose, ViewModels, a repository over Room, Hilt for dependency injection). This README, though, is about what the app *does* — and what it could do next.

## Screenshots

<img src="screenshots/screenshots.png" alt="Screenshot">

## What the app can do today

### Manage your tasks
* **Add a task** with a title and a description (both are required).
* **Edit** an existing task's title and description.
* **Mark a task complete or active** — straight from the list with a checkbox, or from the task's detail screen. Completed tasks are shown with strikethrough.
* **Open a task** to see its full title, description, and status.
* **Delete a single task** from its detail screen.
* **Clear all completed tasks** at once from the list's overflow menu.

### Find what matters
* **Filter the list** by All, Active, or Completed; the header shows which view you're in.
* **Tailored empty states** per filter ("You have no active tasks!", and so on), so an empty list still tells you something useful.

### See your progress
* **Statistics screen** showing the share of active vs. completed tasks as percentages.

### Get around
* **Navigation drawer** to switch between the task list and the statistics screen.
* **Pull-to-refresh** (and a Refresh action) on every list, re-pulling from the data source.
* **Snackbar confirmations** for every change: task added, saved, deleted, marked complete or active, completed cleared.

### Under the hood
Tasks live in a local **Room** database. Every change also pushes, in the background, to a fake in-memory "network" source seeded with two sample tasks, so you can watch a one-way sync work without a real backend behind it. `refresh` replaces the local data with the network contents.

## What could be built next

The app is a foundation, not a finished product. Natural next features:

* **Due dates and reminders** — give a task a deadline and fire a notification as it approaches.
* **Priorities and sorting** — flag important tasks and sort by priority, date, or title.
* **Categories, tags, or multiple lists** — group tasks (Work / Home / Shopping) and filter by group.
* **Search** — find a task by title or description as the list grows.
* **Subtasks and checklists** — break a task into smaller steps.
* **Swipe actions and undo** — swipe to complete or delete, with an undo snackbar.
* **A real backend** — replace the fake in-memory source with a real API, turning today's one-way push into proper two-way sync with conflict handling.
* **Accounts and multiple devices** — sign in and keep the same list everywhere.
* **Theming and a home-screen widget** — dark mode, dynamic color, and a widget showing today's tasks.
* **Richer statistics** — completed-per-day trends, streaks, or a chart on the statistics screen.

## Opening the project in Android Studio

Check out the branch you want to explore, then open the repository's root directory in Android Studio.

### License

```
Copyright 2024 Google, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership. The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
```
