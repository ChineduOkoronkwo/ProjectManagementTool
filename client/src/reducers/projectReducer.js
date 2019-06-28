import { GET_PROJECTS } from "../actions/types";

const intitialState = {
    projects: [],
    project: {}
};

export default function(state = intitialState, action) {
    switch (action.type) {
        case GET_PROJECTS:
            return {
                ...state,
                projects: action.payload
            };

        default:
            return state;
    }
}