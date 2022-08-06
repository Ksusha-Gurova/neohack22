import {
    EFFICIENCY_DASHBOARD_ROUTE,
    FORUM_ROUTE,
    LEARNING_ROUTE,
    LOGIN_ROUTE,
    PROFILE_ROUTE,
    ROOT,
    STATISTICS_ROUTE,
    TEST_ROUTE,
    THEME_ROUTE
} from './utils/consts';
import { ProfileContainer } from './container/profileContainer';
import { LearningContainer } from './container/learningContainer';
import { StatisticContainer } from './container/statisticContainer';
import { EfficiencyDashboardContainer } from './container/efficiencyDashboardContainer';
import { ForumContainer } from './container/forumContainer';
import { TestContainer } from './container/testContainer';
import { Auth } from './components/auth';
import { MainComponent } from './components/mainComponent';
import { ThemeContainer } from './container/themeContainer';

export const publicRoutes = [
    {
        path: LOGIN_ROUTE,
        Component: Auth
    }
]

export const authRoutes = [
    {
        path: ROOT,
        Component: MainComponent
    },
    {
        path: TEST_ROUTE,
        Component: TestContainer
    },
    {
        path: THEME_ROUTE,
        Component: ThemeContainer
    },
    {
        path: PROFILE_ROUTE,
        Component: ProfileContainer
    },
    {
        path: LEARNING_ROUTE,
        Component: LearningContainer
    },
    {
        path: STATISTICS_ROUTE,
        Component: StatisticContainer
    },
    {
        path: EFFICIENCY_DASHBOARD_ROUTE,
        Component: EfficiencyDashboardContainer
    },
    {
        path: FORUM_ROUTE,
        Component: ForumContainer
    }
]