package filter

import javax.inject.Inject
import play.api.http.DefaultHttpFilters
import com.github.stijndehaes.playprometheusfilters.filters.LatencyFilter
import com.github.stijndehaes.playprometheusfilters.filters.StatusCounterFilter

class MyFilters @Inject() (
                            latencyFilter: LatencyFilter,
                            statusCounterFilter: StatusCounterFilter
                          ) extends DefaultHttpFilters(latencyFilter, statusCounterFilter)